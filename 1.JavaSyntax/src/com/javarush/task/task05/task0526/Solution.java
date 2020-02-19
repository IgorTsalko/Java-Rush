package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man firstMan = new Man("Виктор", 46, "New York");
        Man secondMan = new Man("Игорь", 25, "Minsk");

        Woman firstWoman = new Woman("Светлана", 28, "Los-Angeles");
        Woman secondWoman = new Woman("Настя", 24, "Minsk");

        System.out.println(firstMan.name + " " + firstMan.age + " " + firstMan.address);
        System.out.println(secondMan.name + " " + secondMan.age + " " + secondMan.address);
        System.out.println(firstWoman.name + " " + firstWoman.age + " " + firstWoman.address);
        System.out.println(secondWoman.name + " " + secondWoman.age + " " + secondWoman.address);
    }
    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
