package com.javarush.task.task14.task1404;

import java.io.*;
import java.util.ArrayList;

/* 
Коты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Cat> cats = new ArrayList<>();

        while (true) {
            String str = reader.readLine();
            Cat cat;
            if (str.isEmpty())
                break;
            else
                cats.add((cat = CatFactory.getCatByKey(str)));
        }

        for (Cat c : cats) {
            System.out.println(c.toString());
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
