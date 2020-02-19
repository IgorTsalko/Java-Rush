package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        countEvenAndOdd(num);
        System.out.print("Even: " + even + " ");
        System.out.print("Odd: " + odd);
    }

    public static void countEvenAndOdd (int num) {
        int number = num;

        while (number > 1) {
            int checkNum = number % 10;
            if (checkNum % 2 == 0)
                even++;
            else
                odd++;

            number /= 10;
        }

//        int divider = 10;
//        int a = 0;
//        int b;
//        for (int i = 1; ;i++) {
//            if (num % divider < 10 && i == 1) {
//                a = num % divider;
//                if (a % 2 == 0)
//                    even++;
//                else
//                    odd++;
//            } else {
//                divider *= 10;
//                if (num % divider < 10 && i > 1) {
//                    break;
//                }
//                b = (num % divider - a) / (divider / 10);
//                if (b % 2 == 0)
//                    even++;
//                else
//                    odd++;
//
//                if (num % divider >= num)
//                    break;
//            }
//        }
    }
}
