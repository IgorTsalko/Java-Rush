package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
    }


    public static void main(String[] args) {

    }
}
