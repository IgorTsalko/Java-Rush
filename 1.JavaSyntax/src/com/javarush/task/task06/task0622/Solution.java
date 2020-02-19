package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        ascendingPrint(arr);
    }
    public static void ascendingPrint (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i +1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int num = arr[j];
                    arr[j] = arr[i];
                    arr[i] = num;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
