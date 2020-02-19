package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        FileInputStream in = new FileInputStream(args[0]);
        int count = 0;
        String s;

        while (in.available() > 0) {
            s = String.valueOf((char) in.read());
            if (alphabet.contains(s.toLowerCase())) {
                count++;
            }
        }

        System.out.println(count);

        in.close();
    }
}
