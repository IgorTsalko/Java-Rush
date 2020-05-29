package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        String readText;

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(number);

        byte[] buff = new byte[text.length()];
        randomAccessFile.read(buff, 0, buff.length);
        readText = new String(buff);

        randomAccessFile.seek(randomAccessFile.length());
        if (readText.equals(text)) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }

        randomAccessFile.close();
    }
}
