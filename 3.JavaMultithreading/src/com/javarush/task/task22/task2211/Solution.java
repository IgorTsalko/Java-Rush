package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]);

        byte[] buffIn = new byte[in.available()];
        in.read(buffIn);
        String line = new String(buffIn, "Windows-1251");

        byte[] buffOut = line.getBytes();
        out.write(buffOut);
    }
}
