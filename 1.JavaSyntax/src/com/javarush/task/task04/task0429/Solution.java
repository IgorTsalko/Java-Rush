package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int positiveCount = 0;
        int negativeCount = 0;
        for (int i = 1; i <= 3; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num > 0)
                positiveCount++;
            else if (num < 0)
                negativeCount++;
        }
        System.out.println("количество отрицательных чисел: " + negativeCount);
        System.out.println("количество положительных чисел: " + positiveCount);
        Double d4 = new Double("1L");
    }
}