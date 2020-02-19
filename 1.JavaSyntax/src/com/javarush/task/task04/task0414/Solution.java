package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int year = (new Scanner(System.in)).nextInt();
        checkYear(year);
    }
    public static void checkYear(int year) {
        int vis = 366;
        int notVis = 365;

        if ((year % 4 == 0 && year % 100 > 0) || year % 400 == 0)
            System.out.println("количество дней в году: " + vis);
        else
            System.out.println("количество дней в году: " + notVis);
    }
}