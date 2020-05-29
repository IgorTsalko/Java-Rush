package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            checkNumberForRadix(args[0]);
        } catch (Exception e) {

        }

    }

    private static void checkNumberForRadix(String number) {
        int radix = 0;

        for (int i = 2; i <= 36; i++) {
            try {
                new BigInteger(number, i);
                radix = i;
                break;
            } catch (Exception e) {
            }
        }

        if (radix == 0) {
            System.out.println("incorrect");
        } else {
            System.out.println(radix);
        }
    }
}