package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream out = new FileOutputStream(reader.readLine());

        String s = "";
        while (in.available() > 0) {
            int b = in.read();
            if (b == 32) {
                double num = Math.round(Double.parseDouble(s));
                out.write(((int) num + " ").getBytes());
                s = "";
                continue;
            }
            s += String.valueOf((char) b);
        }
        double num = Math.round(Double.parseDouble(s));
        out.write(String.valueOf((int) num).getBytes());

        reader.close();
        in.close();
        out.close();

//        E:/java/files2/firstfile.txt
//        E:/java/files2/secondfile.txt
    }
}
