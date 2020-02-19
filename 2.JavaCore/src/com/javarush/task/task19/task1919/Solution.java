package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> sortedMap = new TreeMap<>();

            String line;
            while ((line = in.readLine()) != null) {
                String[] tmp = line.split(" ");
                String family = tmp[0];
                double value = Double.parseDouble(tmp[1]);
                sortedMap.put(family, sortedMap.containsKey(family) ? sortedMap.get(family) + value : value);
            }
            sortedMap.forEach((k,v)->System.out.println(k + " " + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
