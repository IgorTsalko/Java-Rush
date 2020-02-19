package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        while (true) {
            String str = reader.readLine();
            text += str + "\n";
            if (str.equals("exit")) {
                break;
            }
        }

        bufferedWriter.write(text);

        bufferedWriter.close();
        reader.close();
    }
}
