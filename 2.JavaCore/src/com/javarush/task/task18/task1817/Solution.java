package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        int numberOfSpaces = 0;
        int characters = in.available();

        while (in.available() > 0) {
            if (in.read() == 32) {
                numberOfSpaces++;
            }
        }

        double ratio = (double) numberOfSpaces / characters * 100;
        System.out.printf("%.2f", ratio);

        in.close();
    }
}
