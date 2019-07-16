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

        String nick = player.nick;
        Integer level = player.level;
        Integer HP = player.HP;
        Float money = player.money;

        fout.write(nick.getBytes());
        fout.write((byte)35);
        fout.write(level.byteValue());
        fout.write((byte)35);
        fout.write(HP.byteValue());
        fout.write((byte)35);
        fout.write(money.byteValue());
        fout.close();
    }
}
