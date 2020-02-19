package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String name = buffer.readLine();

        for (int i = 1; i <= 10; i++) {
            System.out.println(name + " любит меня.");
        }
    }
}
