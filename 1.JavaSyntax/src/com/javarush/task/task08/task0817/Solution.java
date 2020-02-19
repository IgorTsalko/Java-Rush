package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> newMap = new HashMap<>();
        newMap.put("Петров", "Федор");
        newMap.put("Сидоров", "Михаил");
        newMap.put("Калчанов", "Федор");
        newMap.put("Иванов", "Федор");
        newMap.put("Михайлов", "Кирилл");
        newMap.put("Песков", "Алексей");
        newMap.put("Медведев", "Денис");
        newMap.put("Тарасов", "Кирилл");
        newMap.put("Константинов", "Матвей");
        newMap.put("Пупкин", "Евгений");

        return newMap;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        ArrayList<String> valuesMap = new ArrayList<>();

        for (Map.Entry<String, String> pair : map.entrySet()) {
            valuesMap.add(pair.getValue());
        }

        for (int i = 0; i < valuesMap.size() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < valuesMap.size(); j++) {
                if (valuesMap.get(i) == valuesMap.get(j))
                    removeItemFromMapByValue(map, valuesMap.get(i));
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
    }
}
