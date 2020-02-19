package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in;
        FileOutputStream out;
        byte[] firstBuffer;
        byte[] secondBuffer;
        String firstName = reader.readLine();
        String secondName = reader.readLine();

        in = new FileInputStream(firstName);
        firstBuffer = new byte[in.available()];
        in.read(firstBuffer);
        in.close();

        in = new FileInputStream(secondName);
        secondBuffer = new byte[in.available()];
        in.read(secondBuffer);
        in.close();

        out = new FileOutputStream(firstName);
        out.write(secondBuffer);
        out.write(firstBuffer);
        out.close();
    }
}
