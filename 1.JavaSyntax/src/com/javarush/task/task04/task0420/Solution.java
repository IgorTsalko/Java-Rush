package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        String s = "";
        if (a >= b && a >= c) {
            s += a + " ";
            if (b > c)
                s += b + " " + c;
            else
                s += c + " " + b;
        }
        else if (b >= a && b >= c) {
            s += b + " ";
            if (a > c)
                s += a + " " + c;
            else
                s += c + " " + a;
        }
        else if (c >= a && c >= b) {
            s += c + " ";
            if (a > b)
                s += a + " " + b;
            else
                s += b + " " + a;
        }

        System.out.println(s);
    }

}
