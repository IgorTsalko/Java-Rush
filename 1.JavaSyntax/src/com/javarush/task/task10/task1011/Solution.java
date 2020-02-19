package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        for (int i = 0; i < 40; i++) {
            System.out.println(s.substring(i));
        }
    }
}

