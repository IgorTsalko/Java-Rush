package com.javarush.task.task25.task2512;

import java.io.PrintWriter;
import java.io.StringWriter;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        recursionPrint(e);
    }

    private void recursionPrint(Throwable e) {
        if (e.getCause() != null) {
            recursionPrint(e.getCause());
        }
        System.out.println(e);
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }

}
