package Lesson_3.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class MultiRead {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> list = new ArrayList<>();
        list.add(new FileInputStream("part1.txt"));
        list.add(new FileInputStream("part2.txt"));
        list.add(new FileInputStream("part3.txt"));
        list.add(new FileInputStream("part4.txt"));
        list.add(new FileInputStream("part5.txt"));


        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(list));

        int x;
        byte[] buff = new byte[512];

        while((x = in.read(buff)) > 0){
            System.out.println(new String(buff, 0 , x));
        }
    }
}
