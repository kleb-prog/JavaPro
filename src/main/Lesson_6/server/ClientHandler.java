package Lesson_6.server;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MainServer server;
    private String nick;

    final static Logger logger = Logger.getLogger(ClientHandler.class.getName());

    public ClientHandler(Socket socket, MainServer server) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String str = in.readUTF();

                            //Авторизация
                            if (str.startsWith("/auth ")){
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                System.out.println(newNick);
                                if (newNick != null){
                                    if (!server.isNickExist(newNick)){
                                        sendMsg("/authok " + newNick);
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        logger.info("Подключен пользователь с ником: " + nick);
                                        break;
                                    }else {
                                        sendMsg("Этот пользователь уже авторизован!");
                                        logger.info("Повторная попытка входа: " + nick);
                                    }
                                }else {
                                    sendMsg("Неверный логин/пароль!");
                                    logger.warn("Введены неверные данные при авторизации пользователя");
                                }
                            }

                            //Регистрация
                            if (str.startsWith("/register ")){
                                String[] tokens = str.split(" ", 4);
                                if (AuthService.registerNewUser(tokens[1], tokens[2], tokens[3])){
                                    sendMsg("Регистрация успешна");
                                    logger.info("Регистрация нового пользователя: " + tokens[1]);

                                }else {
                                    sendMsg("Ошибка регистрации");
                                    logger.warn("Ошибка регистрации нового пользователя");
                                }
                            }

                        }
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")){
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverClosed");
                                    logger.info("Пользователь отключился: " + nick);
                                    break;
                                }
                                else if (str.startsWith("/w")){
                                    String[] tokens = str.split(" ", 3);
                                    if (tokens.length != 3) continue;
                                    server.broadCastMsg(tokens[2], tokens[1], nick);
                                    logger.info("Пользователь " + nick + " отправил личное сообщение для " + tokens[1]);
                                }
                                else if (str.startsWith("/blackList ")){                    //Добавление в черный список
                                    String banNick = str.split(" ")[1];
                                    int id = AuthService.getIdByNick(nick);
                                    if (!(banNick == null) && AuthService.getIdByNick(banNick) != -1){
                                        AuthService.addUserToBlacklist(id, banNick);
                                        sendMsg("Ник " + banNick + " успешно добавлен в черный список");
                                        logger.info("Пользователь " + nick + " добвил в черный список пользователя " + banNick);
                                    }else {
                                        sendMsg("Ник не найден");
                                        logger.info("Нудачная попытка добавить пользователя в черный список от " + nick);
                                    }
                                }
                            }else {
                                server.broadCastMsg(ClientHandler.this, nick + ": " + str);
                                logger.info("Пользователь " + nick + " отправил сообщение - " + str);
                            }
                        }
                    } catch (IOException e) {
                        try {
                            socket.close();
                            server.unsubscribe(ClientHandler.this);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } finally {
                        try {
                            socket.close();
                            server.unsubscribe(ClientHandler.this);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getNick(){
        return nick;
    }
    public boolean blockedNextUser(String senderNick){
        int id = AuthService.getIdByNick(this.nick);
        ArrayList<String> bannedUsers = AuthService.getBannedUsers(id);
        if (bannedUsers != null){
            return bannedUsers.contains(senderNick);
        }else {
            return false;
        }
    }

}
