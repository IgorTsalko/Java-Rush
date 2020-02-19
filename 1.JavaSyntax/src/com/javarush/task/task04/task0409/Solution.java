package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
    }

    public static void displayClosestToTen(int a, int b) {
        // напишите тут ваш код
        int numOne = 10 - a;
        numOne = abs(numOne);
        int numTwo = 10 - b;
        numTwo = abs(numTwo);

        if (numOne < numTwo)
            System.out.println(a);
        else if (numOne == numTwo) {
            System.out.println(a);
        }
        else
            System.out.println(b);
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}