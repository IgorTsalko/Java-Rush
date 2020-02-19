package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> catMap = new HashMap<>();

        catMap.put("Барсик", new Cat("Барсик"));
        catMap.put("Мурзик", new Cat("Мурзик"));
        catMap.put("Пусик", new Cat("Пусик"));
        catMap.put("Масик", new Cat("Масик"));
        catMap.put("Пушок", new Cat("Пушок"));
        catMap.put("Венчик", new Cat("Венчик"));
        catMap.put("Котик", new Cat("Котик"));
        catMap.put("Дымок", new Cat("Дымок"));
        catMap.put("Снежок", new Cat("Снежок"));
        catMap.put("Кустик", new Cat("Кустик"));

        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>();
        for (Map.Entry<String, Cat> cat : map.entrySet()) {
            catSet.add(cat.getValue());
        }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
