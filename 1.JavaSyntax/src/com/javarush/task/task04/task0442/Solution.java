package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int summ = 0;

        while (true) {
            int num = Integer.parseInt(buffer.readLine());
            summ += num;
            if (num == -1)
                break;
        }
        System.out.println(summ);
    }
}
