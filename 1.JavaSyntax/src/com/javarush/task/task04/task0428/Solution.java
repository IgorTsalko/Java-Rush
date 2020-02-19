package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num > 0)
                count++;
        }
        System.out.println(count);
    }
}
