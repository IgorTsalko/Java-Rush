package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();

        System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");
    }
}
