package Lesson_3;

import java.io.*;
import java.net.Socket;

public class Client {

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;



    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Player player = new Player("Grand", 80, 100, 1045645.58f);
        client.serialize(player);
        client.sendToServer();
    }



    public void sendToServer() throws IOException {
        Socket socket = new Socket(IP_ADRESS, PORT);

        FileInputStream fin = new FileInputStream("obj.ser");
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int x;
        byte[] buff = new byte[512];

        while ((x = fin.read(buff)) > 0){
            bos.write(buff, 0, x);
        }
        fin.close();
        bos.close();

    }

    public void serialize(Player player) throws IOException {
        FileOutputStream fout = new FileOutputStream("obj.ser");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));

        String nick = player.nick;
        Integer level = player.level;
        Integer HP = player.HP;
        Float money = player.money;

        StringBuilder sb = new StringBuilder();
        sb.append(nick).append("#");
        sb.append(level).append("#");
        sb.append(HP).append("#");
        sb.append(money);

        writer.write(sb.toString());
        writer.close();
    }
}
