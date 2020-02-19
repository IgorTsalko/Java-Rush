package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> peopleList = new HashMap<>();
        peopleList.put("Петров", "Александр");
        peopleList.put("Сидоров", "Федор");
        peopleList.put("Иванов", "Гриша");
        peopleList.put("Куклев", "Александр");
        peopleList.put("Иванов", "Александр");
        peopleList.put("Петров", "Александр");
        peopleList.put("Мартышков", "Кирилл");
        peopleList.put("Комочков", "Генадий");
        peopleList.put("Песков", "Александр");
        peopleList.put("Петров", "Константин");

        return peopleList;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
