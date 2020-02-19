package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int n = (new Scanner(System.in)).nextInt();
        checkNumber(n);
    }

    public static void checkNumber(int n) {
        if (n > 0) {
            n *= 2;
            System.out.println(n);
        } else if (n < 0) {
            n += 1;
            System.out.println(n);
        } else if (n == 0)
            System.out.println(0);
    }

}