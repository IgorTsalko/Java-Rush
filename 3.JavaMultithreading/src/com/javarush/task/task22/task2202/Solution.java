package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(getPartOfString("A - luchiy servis obucheni"));
//            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        } catch (TooShortStringException e) {
            e.printStackTrace();
        }
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String result = null;
        int endIndex = orderIndex(string, " ", 4);
        if (endIndex == -1) {
            throw new TooShortStringException();
        }
        if (string.indexOf(' ', endIndex + 1) != -1) {
            result = string.substring(string.indexOf(' ') + 1, string.indexOf(' ', endIndex + 1));
        } else {
            result = string.substring(string.indexOf(' ') + 1);
        }

        return result;
    }

    private static int orderIndex(String str, String subStr, int order) throws TooShortStringException {
        if (str == null) {
            throw new TooShortStringException();
        }
        int index = 0;
        for (int i = 0; i < order; i++) {
            index = str.indexOf(subStr, index + 1);
            if (index == -1) {
                return -1;
            }
        }
        return index;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
