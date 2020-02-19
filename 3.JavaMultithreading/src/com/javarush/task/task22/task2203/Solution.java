package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int startIndex = string.indexOf("\t") + 1;
        int endIndex = string.indexOf("\t", startIndex);
        if (startIndex == -1 || endIndex == -1) {
            throw new TooShortStringException();
        }
        return string.substring(startIndex, endIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
