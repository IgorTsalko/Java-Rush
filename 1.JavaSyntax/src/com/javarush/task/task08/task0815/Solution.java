package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> population = new HashMap<>();

        population.put("Петров", "Дмитрий");
        population.put("Иванов", "Александр");
        population.put("Сидоров", "Вадим");
        population.put("Скворцов", "Кирилл");
        population.put("Ведров", "Александр");
        population.put("Тумбов", "Евгений");
        population.put("Песков", "Александр");
        population.put("Шнуров", "Артур");
        population.put("Стулов", "Михаил");
        population.put("Хренов", "Василий");

        return population;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                    if (iterator.next().getValue() == name)
                        count++;
            }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey() == lastName)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
