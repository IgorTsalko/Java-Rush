package com.javarush.task.task04.task0438;

/* 
Рисуем линии
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int num = 8;

        for (int i = 1; i <= 20; i++) {
            if (i < 10)
                System.out.print(num);
            else if (i >= 10)
                System.out.print(num + "\n");
        }

    }
}
