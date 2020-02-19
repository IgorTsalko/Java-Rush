package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int num = 8;
        String str = "";

        for (int i = 1; i <= 10; i++) {
            str += num;
            System.out.println(str);
        }

    }
}
