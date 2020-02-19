package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int num = 0;
        for (int i = 1; i <= 4; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(reader.readLine());
            if (i == 1)
                num = s;
            else if (s > num)
                num = s;
        }
        System.out.println(num);
    }
}
