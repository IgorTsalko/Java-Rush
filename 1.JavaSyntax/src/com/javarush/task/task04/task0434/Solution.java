package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int factor = 1;

        while (factor <= 10) {
            int num = 1;
            int numTwoo;
            String str = "";

            int count = 1;
            while (count <= 10) {
                numTwoo = num * factor;
                str += numTwoo + " ";
                num++;
                count++;
            }
            factor++;
            System.out.println(str);
        }

    }
}
