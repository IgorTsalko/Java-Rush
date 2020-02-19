package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));

            String str;
            while ((str = in.readLine()) != null) {
                out.write(str.replaceAll("\\.", "!"));
            }

            reader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        E:/Java/Files/firstFile.txt
//        E:/Java/Files/fourthFile.txt
    }
}
