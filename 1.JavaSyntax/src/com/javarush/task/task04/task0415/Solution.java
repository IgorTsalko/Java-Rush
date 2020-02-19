package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int oneSide = scan.nextInt();
        int twoSide = scan.nextInt();
        int threeSide = scan.nextInt();
        scan.close();

        checkTriangle(oneSide, twoSide, threeSide);
    }
    public static void checkTriangle (int num1, int num2, int num3) {
        if ((num1 + num2) > num3 && (num1 + num3) > num2 && (num2 + num3) > num1)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
    }
}