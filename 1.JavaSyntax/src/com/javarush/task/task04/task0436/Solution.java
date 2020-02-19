package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(buffer.readLine());
        int n = Integer.parseInt(buffer.readLine());
        int num = 8;
        String str = "";

        for (int i = 1; i <= n; i++) {
            str += num;
        }
        for (int i = 1; i <= m; i++) {
            System.out.println(str);
        }
    }
}
