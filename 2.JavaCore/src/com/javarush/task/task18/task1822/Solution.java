package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()));

        String line;
        while ((line = readFile.readLine()) != null) {
            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
            }
        }
        reader.close();
        readFile.close();
    }
}
