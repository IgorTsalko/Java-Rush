package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream out = new FileOutputStream(reader.readLine());
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
            PrintStream arrayStream =  new PrintStream(arrayOut);
            System.setOut(arrayStream);

            testString.printSomething();
            out.write(arrayOut.toByteArray());
            System.setOut(consoleStream);
            System.out.println(arrayOut.toString());
            reader.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

