package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int firstDigit = (number - number % 100) / 100;
        int thirdDigit = number % 10;
        int secondDigit = (number % 100 - thirdDigit) / 10;
        int summ = firstDigit + secondDigit + thirdDigit;
        return summ;
    }
}