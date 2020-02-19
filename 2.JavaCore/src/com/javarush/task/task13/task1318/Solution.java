package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0) {
            char c = (char) fileInputStream.read();
            System.out.print(c);
        }

        reader.close();
        fileInputStream.close();
    }
}