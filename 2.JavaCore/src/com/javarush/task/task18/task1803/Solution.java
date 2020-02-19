package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        int value = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (map.containsKey(b)) map.put(b, map.get(b) + 1);
            else map.put(b, 1);
        }

        inputStream.close();

        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (value < num.getValue()) {
                list.clear();
                list.add(num.getKey());
                value = num.getValue();
            } else if (value == num.getValue()) list.add(num.getKey());
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
