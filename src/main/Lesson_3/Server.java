package Lesson_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {

    Socket client;
    Boolean ready;

    public Server() throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Сервер запущен");
        while (true){
            client = server.accept();
            deserialize();
        }
    }

    public static void main(String[] args) throws IOException {
        Server serv = new Server();
        Player player1;

        while (true){
            if (serv.ready){

            }
        }

    }



    public void deserialize() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
        FileOutputStream fos = new FileOutputStream("deobj.ser");

        int x;
        byte[] buff = new byte[512];

        while ((x = bis.read(buff)) > 0){
            fos.write(buff, 0, x);
        }

    }


    public Player createPlayerFromSer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("deobj.ser")));

        String line;
        ArrayList<String> lines = new ArrayList<>();


        while ((line = reader.readLine()) != null){
            lines.add(line);
        }

        String nick ;
        Integer level;
        Integer HP ;
        Float money;

        //Player player = new Player();
    }

}
