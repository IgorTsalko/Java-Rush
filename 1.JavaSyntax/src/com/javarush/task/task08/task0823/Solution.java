package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String newString = "";
        char[] chars = string.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] != ' ' || chars[i -1] == ' ')
                newString += String.valueOf(chars[i]).toUpperCase();
            else
                newString += String.valueOf(chars[i]);
        }

        System.out.println(newString);
    }
}
