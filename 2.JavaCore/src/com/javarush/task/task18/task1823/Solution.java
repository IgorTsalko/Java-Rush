package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        E:/Java/Files/firstFile.txt
//        E:/Java/Files/secondFile.txt

        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }

    }

    public static class ReadThread extends Thread {
        FileInputStream in;
        byte[] buffer;
        public ReadThread(String fileName) throws IOException {
            super(fileName);
            in = new FileInputStream(fileName);
        }

        @Override
        public void run() {
            try {
                buffer = new byte[in.available()];
                in.read(buffer);
                resultMap.put(getName(), searchMaxByte());
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private int searchMaxByte() {
            int maxByte = 0;
            int repeat = 0;
            for (int i = 0; i < buffer.length - 1; i++) {
                int count = 0;
                for (int j = i + 1; j < buffer.length; j++) {
                    if (buffer[i] == buffer[j]) {
                        count++;
                    }
                }
                if (count > repeat) {
                    repeat = count;
                    maxByte = buffer[i];
                }
            }
            return maxByte;
        }
    }
}
