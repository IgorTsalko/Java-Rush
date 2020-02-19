package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numArrOne = new int[20];
        int[] numArrTwo = new int[10];
        int[] numArrThree = new int[10];

        for (int i = 0; i < numArrOne.length; i++) {
            numArrOne[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < numArrOne.length; i++) {
            if (i <= 9)
                numArrTwo[i] = numArrOne[i];
            else {
                numArrThree[i - 10] = numArrOne[i];
                System.out.println(numArrThree[i - 10]);
            }
        }
    }
}
