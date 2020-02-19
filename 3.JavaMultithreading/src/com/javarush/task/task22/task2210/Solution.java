package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] result = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(result));
    }
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[tokenizer.countTokens()];
        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            result[count++] = tokenizer.nextToken();
        }
        return result;
    }
}
