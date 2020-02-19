package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;
        int count = 0;

        while (true) {
            int num = Integer.parseInt(buffer.readLine());
            if (num == -1)
                break;

            summ += num;
            count++;
        }
        double mean = (double) summ/count;
        System.out.println(mean);
    }
}

