package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> sortedMap = new TreeMap<>();
            String name;
            double value;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                name = temp[0];
                value = Double.parseDouble(temp[1]);

                sortedMap.put(name, sortedMap.containsKey(name)? sortedMap.get(name) + value : value);
            }

            double maxValue = 0;
            for (Map.Entry pair : sortedMap.entrySet()) {
                if ((double) pair.getValue() > maxValue) {
                    maxValue = (double) pair.getValue();
                }
            }

            for (Map.Entry pair : sortedMap.entrySet()) {
                if ((double) pair.getValue() == maxValue) {
                    System.out.println(pair.getKey());
                }
            }
        } catch (IOException e) {

        }
    }
}
