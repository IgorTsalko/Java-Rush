package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        PrintStream arrayStream = new PrintStream(arrayOut);
        System.setOut(arrayStream);
        testString.printSomething();
        String[] result = arrayOut.toString().split(System.lineSeparator());
        System.setOut(consoleStream);

        for (int i = 0; i < result.length; i++) {
            if (i%2 == 0 && i != 0) {
                System.out.print("JavaRush - курсы Java онлайн\n");
            }
            System.out.println(result[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
