package Lesson_3.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;


// Чтение файла больше 10мб задание № 3!!!!


public class PageReader {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("book.txt", "r");

        System.out.println("Страниц = " + (raf.length() / 2) / 1800);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер страницы (отсчет с ноля):");
        int page = Integer.parseInt(reader.readLine());


        System.out.println(readPage(page, raf));

    }

    public static String readPage(int from, RandomAccessFile raf) throws IOException {


        StringBuffer result = new StringBuffer();
        raf.seek(from * 3600);


        int x;
        int count = 0;

        while((x = raf.read()) != -1 && count < 3600){
            result.append((char) x);
            count++;
        }
        raf.close();
        System.out.println("Байт прочитано: " + count);

        String page = new String(result.toString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return page;


    }

}
