package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);
            byte[] bufferIn = new byte[in.available()];

            if (args[0].equals("-e")) {
                while (in.available() > 0) {
                    out.write(in.read() + 1);
                }
            } else if(args[0].equals("-d")) {
                while (in.available() > 0) {
                    out.write(in.read() - 1);
                }
            } else {
                System.out.println("Неверный параметр");
            }
            out.close();
            in.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Файл не найден!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
