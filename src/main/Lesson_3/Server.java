package Lesson_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    Socket client;
    Boolean serialReady;

    public Server() throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Сервер запущен");
        while (true){
            client = server.accept();
            deserialize();
            break;
        }
    }

    public static void main(String[] args) throws IOException {
        Server serv = new Server();
        Player player1;

        while (true){
            if (serv.serialReady){
                player1 = serv.createPlayerFromSer();
                break;
            }
        }

        player1.info();

    }



    public void deserialize() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
        FileOutputStream fos = new FileOutputStream("deobj.ser");

        int x;
        byte[] buff = new byte[512];

        while ((x = bis.read(buff)) > 0){
            fos.write(buff, 0, x);
        }

        serialReady = true;
        bis.close();
        fos.close();

    }


    public Player createPlayerFromSer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("deobj.ser")));

        String[] lines = reader.readLine().split("#");

        String nick = lines[0];
        int level = Integer.parseInt(lines[1]);
        int HP = Integer.parseInt(lines[2]);
        float money = Float.parseFloat(lines[3]);
        reader.close();

        return new Player(nick, level, HP, money);
    }

}
