package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s = "S";
        int num = 1;
        int numTwoo = 1;
        String sss = "";

        while (num <= 10) {
            num++;
            if (sss == "") {
                while (numTwoo <= 10) {
                    numTwoo++;
                    sss += s;
                }
            }
            System.out.println(sss);
        }
    }
}
