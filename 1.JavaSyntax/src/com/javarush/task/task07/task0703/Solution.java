package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strArgs = new String[10];
        int[] numArgs = new int[10];
        for (int i = 0; i < strArgs.length; i++) {
            strArgs[i] = reader.readLine();
        }
        for (int i = 0; i < numArgs.length; i++) {
            numArgs[i] = strArgs[i].length();
            System.out.println(numArgs[i]);
        }
    }
}
