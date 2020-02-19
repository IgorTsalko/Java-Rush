package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader in = new BufferedReader(new FileReader(reader.readLine()))) {
            StringBuilder line;
            while (in.ready()) {
                line = new StringBuilder(in.readLine());
                System.out.println(line.reverse());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
