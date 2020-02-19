package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));

            while (in.ready()) {
                String[] line = in.readLine().split(" ");
                StringBuilder data = new StringBuilder();
                for (int i = 0; i < line.length; i++) {
                    if (line[i].matches("\\d+")) {
                        int num = Integer.parseInt(line[i]);
                        if (num >= 0 && num <= 12) {
                            line[i] = map.get(num);
                        }
                    }
                    data.append(line[i] + " ");
                }
                System.out.println(data.toString());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
