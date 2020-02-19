package com.javarush.task.task04.task0413;


/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int reader = (new Scanner(System.in)).nextInt();
        showDayWeek(reader);
    }
    public static void showDayWeek (int reader) {
        if (reader < 1 || reader > 7)
            System.out.println("такого дня недели не существует");
        else if (reader == 1)
            System.out.println("понедельник");
        else if (reader == 2)
            System.out.println("вторник");
        else if (reader == 3)
            System.out.println("среда");
        else if (reader == 4)
            System.out.println("четверг");
        else if (reader == 5)
            System.out.println("пятница");
        else if (reader == 6)
            System.out.println("суббота");
        else if (reader == 7)
            System.out.println("воскресенье");

    }
}