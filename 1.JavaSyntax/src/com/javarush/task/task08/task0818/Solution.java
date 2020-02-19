package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Петров", 1000);
        map.put("Иванов", 300);
        map.put("Сидоров", 5000);
        map.put("Скворцов", 800);
        map.put("Певцов", 400);
        map.put("Носков", 500);
        map.put("Тарасов", 900);
        map.put("Шнуров", 1200);
        map.put("Просов", 1500);
        map.put("Федоров", 550);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}