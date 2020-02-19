package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        String thirdName = reader.readLine();

        FileInputStream in = new FileInputStream(secondName);
        FileOutputStream out = new FileOutputStream(firstName, true);

        byte[] buffer = new byte[in.available()];

        in.read(buffer);
        out.write(buffer);

        in.close();
        in = new FileInputStream(thirdName);

        buffer = new byte[in.available()];

        in.read(buffer);
        out.write(buffer);

        in.close();
        out.close();
    }
}
