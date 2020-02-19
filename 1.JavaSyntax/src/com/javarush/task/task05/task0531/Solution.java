package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int f = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, f);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int f) {
        if (a <= b && a <= c && a <= d && a <= f)
            return a;
        else if (b <= a && b <= c && b <= d && b <= f)
            return b;
        else if (c <= a && c <= b && c <= d && c <= f)
            return c;
        else if (d <= a && d <= b && d <= c && d <= f)
            return d;
        else
            return f;

    }
}
