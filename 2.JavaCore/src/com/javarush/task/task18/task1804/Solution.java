package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listBytes = new ArrayList<>();
        Map<Integer, Integer> mapRepeats = new HashMap<>();
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int minFrequency;

        while (inputStream.available() > 0) {
            listBytes.add(inputStream.read());
        }

        inputStream.close();

        for (int i = 0; i < listBytes.size(); i++) {
            mapRepeats.put(listBytes.get(i), Collections.frequency(listBytes, listBytes.get(i)));
        }

        minFrequency = Collections.min(mapRepeats.values());

        for (Map.Entry<Integer, Integer> pair : mapRepeats.entrySet()) {
            if (pair.getValue().equals(minFrequency)) System.out.print(pair.getKey() + " ");
        }
    }
}
