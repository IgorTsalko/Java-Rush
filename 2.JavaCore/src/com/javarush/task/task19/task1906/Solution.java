package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Reader in = new FileReader(reader.readLine());
            Writer out = new FileWriter(reader.readLine());

            int count = 1;
            while (in.ready()) {
                int b = in.read();
                if (count++ %2 == 0) {
                    out.write(b);
                }
            }

            reader.close();
            in.close();
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
