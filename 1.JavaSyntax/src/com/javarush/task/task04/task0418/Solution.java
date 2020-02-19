package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        int m = Integer.parseInt(read.readLine());
        findMinNumber(n, m);
    }
    public static void findMinNumber(int n, int m) {
        if (n == m)
            System.out.println(n);
        else if (n < m)
            System.out.println(n);
        else if (n > m)
            System.out.println(m);
    }
}