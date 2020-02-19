package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String country;
        private int age;
        private int height;
        private int weight;
        private boolean sex;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public Human(String name, String country, int age) {
            this.name = name;
            this.country = country;
            this.age = age;
        }

        public Human(String name, String country, int age, int height) {
            this.name = name;
            this.country = country;
            this.age = age;
            this.height = height;
        }

        public Human(String name, String country, int age, int height, int weight) {
            this.name = name;
            this.country = country;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String country, int age, int height, int weight, boolean sex) {
            this.name = name;
            this.country = country;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(int weight) {
            this.weight = weight;
        }

        public Human(String name, boolean sex) {
            this.sex = sex;
        }

    }
}
