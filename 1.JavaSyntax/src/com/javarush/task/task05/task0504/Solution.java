package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat firstCat = new Cat("Васька", 5, 6, 12);
        Cat secondCat = new Cat("Пыска", 2, 3, 6);
        Cat thirdCat = new Cat("Мармышка", 4, 4, 7);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}