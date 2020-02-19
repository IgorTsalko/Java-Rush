package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        int minByte = 0;

        while (inputStream.available() > 0) {
            int num = inputStream.read();
            if (minByte == 0 || minByte > num) minByte = num;
        }

        inputStream.close();
        System.out.println(minByte);
    }
}
