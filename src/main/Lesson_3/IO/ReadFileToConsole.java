package Lesson_3.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileToConsole {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileInputStream fis = new FileInputStream(file);
        int x;
        byte[] buff = new byte[512];

        while ((x = fis.read(buff)) > 0){
            System.out.println(new String(buff, 0 , x));
        }
    }

}
