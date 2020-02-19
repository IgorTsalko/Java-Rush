package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }
        int digits = telNumber.replaceAll("\\D", "").length();
        if ((telNumber.charAt(0) == '+' && digits == 12) || (telNumber.charAt(0) != '+' && digits == 10)) {
//            return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
            return telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
        }
        else return false;
    }

    public static void main(String[] args) {
        List<String> checkedNumbers = new ArrayList<>();
        checkedNumbers.add("+380501234567");
        checkedNumbers.add("+38(050)1234567");
        checkedNumbers.add("+38050123-45-67");
        checkedNumbers.add("050123-4567");
        checkedNumbers.add("+38)050(1234567");
        checkedNumbers.add("+38(050)1-23-45-6-7");
        checkedNumbers.add("050ххх4567");
        checkedNumbers.add("050ххх4567");
        checkedNumbers.add("(0)501234567");

        for (String s : checkedNumbers) {
            System.out.println(s + " - " + checkTelNumber(s));
        }
    }
}
