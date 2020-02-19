package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        while (true) {
            int id;
            try {
                id = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                break;
            }

            String name = reader.readLine();

            if (name.isEmpty()) {
                hashMap.put(name, id);
                break;
            }

            hashMap.put(name, id);
        }

        for (Map.Entry<String, Integer> i : hashMap.entrySet()){
            int id = i.getValue();
            String name = i.getKey();
            System.out.println(id + " " + name);
        }


    }
}
