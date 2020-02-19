package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        PrintStream arrayStream = new PrintStream(arrayOut);
        System.setOut(arrayStream);

        testString.printSomething();
        String example = arrayOut.toString().replaceAll("\r\n", "");

        System.setOut(consoleStream);

        Pattern patternNum = Pattern.compile("\\d+");
        Pattern patternSign = Pattern.compile("\\+|-|\\*");
        Matcher matcherNum = patternNum.matcher(example);
        Matcher matcherSign = patternSign.matcher(example);

        int firstNum = 0;
        int secondNum = 0;
        int result = 0;
        String sign = null;

        int count = 0;
        while (matcherNum.find()) {
            if (count++ == 0) {
                firstNum = Integer.parseInt(matcherNum.group());
            } else
                secondNum = Integer.parseInt(matcherNum.group());
        }

        while (matcherSign.find()) {
            sign = matcherSign.group();
        }

        if (sign.equals("+")) {
            result = firstNum + secondNum;
        } else if (sign.equals("-")) {
            result = firstNum - secondNum;
        } else if (sign.equals("*")) {
            result = firstNum * secondNum;
        }

        System.out.printf("%s%d", example, result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

