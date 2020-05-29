package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        if (n > 1) {
            int multiplier = 2;
            while (true) {
                if (n % multiplier == 0) {
                    break;
                } else {
                    multiplier++;
                }
            }
            System.out.println(multiplier);
            if (multiplier != n) {
                recurse(n / multiplier);
            }
        }
    }
}
