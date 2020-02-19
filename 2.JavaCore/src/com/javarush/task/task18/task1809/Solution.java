package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        FileOutputStream out = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[in.available()];

        in.read(buffer);

        for (int i = buffer.length - 1; i >= 0; i--) {
            out.write(buffer[i]);
        }

//        E:/Java/Files2/firstFile.txt
//        E:/Java/Files2/secondFile.txt

        reader.close();
        in.close();
        out.close();
    }
}
