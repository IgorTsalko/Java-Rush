package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder data = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));

            String str;
            while ((str = in.readLine()) != null) {
                data.append(str);
            }
            out.write(data.toString().replaceAll("\\p{Punct}", ""));

            reader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //        E:/Java/Files/firstFile.txt
    //        E:/Java/Files/fourthFile.txt
}
