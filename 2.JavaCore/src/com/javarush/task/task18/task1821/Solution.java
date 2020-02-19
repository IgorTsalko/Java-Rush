package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);

        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < buffer.length; i++) {
            int key = buffer[i];
            if (treeMap.containsKey(key)) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    if ((int) entry.getKey() == key) {
                        entry.setValue((int) entry.getValue() + 1);
                        break;
                    }
                }
            } else {
                treeMap.put(key, 1);
            }
        }

        for (Map.Entry pair : treeMap.entrySet()) {
            System.out.print((char) (int) pair.getKey());
            System.out.println(" " + pair.getValue());
        }
        in.close();
    }
}
