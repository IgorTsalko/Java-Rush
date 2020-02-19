package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
        checkSeason(3);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        if (month == 12 || (month > 0 && month <= 2))
            System.out.println("зима");
        else if (month > 2 && month <= 5)
            System.out.println("весна");
        else if (month > 5 && month <= 8)
            System.out.println("лето");
        else if (month > 8 && month <= 11)
            System.out.println("осень");
    }
}