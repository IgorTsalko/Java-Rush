package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(158);
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        List<Integer> bufNumbers = new ArrayList<>();
        String stringTernaryNumbers = "";
        int num = number;

        while (true) {
            if (num == 1) {
                stringTernaryNumbers += "1";
                break;
            }

            if (num%3 == 2) {
                num = num / 3 + 1;
                stringTernaryNumbers += "-1";
            } else if (num%3 == 1) {
                num = num / 3;
                stringTernaryNumbers += "1";
            } else if (num%3 == 0) {
                num = num / 3;
                stringTernaryNumbers += "0";
            }
        }

        int degree = 0;
        while (stringTernaryNumbers.length() > 0) {
            if (stringTernaryNumbers.startsWith("-1")) {
                bufNumbers.add((int) Math.pow(3, degree) * -1);
                stringTernaryNumbers = stringTernaryNumbers.replaceFirst("-1", "");
            } else if (stringTernaryNumbers.startsWith("1")) {
                bufNumbers.add((int) Math.pow(3, degree));
                stringTernaryNumbers = stringTernaryNumbers.replaceFirst("1", "");
            } else if (stringTernaryNumbers.startsWith("0")) {
                stringTernaryNumbers = stringTernaryNumbers.replaceFirst("0", "");
            }
            degree++;
        }

        System.out.print(number + " =");

        for (Integer i : bufNumbers) {
            if (i > 0) {
                System.out.print(" + " + Math.abs(i));
            } else if ( i < 0) {
                System.out.print(" - " + Math.abs(i));
            }
        }
        System.out.println("");
    }
}