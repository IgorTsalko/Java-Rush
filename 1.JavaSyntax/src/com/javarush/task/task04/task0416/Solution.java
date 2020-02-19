package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double min = (new Scanner(System.in)).nextDouble();

        if (min < 5)
            whichColor(min);
        else
            whichColor(min % 5);
    }
    public static void whichColor (double min) {
            if (min >= 0 && min < 3)
                System.out.println("зелёный");
            if (min >= 3 && min < 4)
                System.out.println("жёлтый");
            if (min >= 4 && min < 5)
                System.out.println("красный");
    }
}