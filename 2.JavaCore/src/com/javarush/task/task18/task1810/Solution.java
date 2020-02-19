package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in;
        String name;

        while (true) {
            name = reader.readLine();
            in = new FileInputStream(name);
            if (in.available() < 1000) {
                reader.close();
                in.close();
                throw new DownloadException();
            }
        }


    }

    public static class DownloadException extends Exception {

    }
}
