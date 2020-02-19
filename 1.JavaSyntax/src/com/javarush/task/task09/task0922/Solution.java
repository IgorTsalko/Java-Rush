package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-M-d");
        Date date = dateFormatIn.parse(reader.readLine());

        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        String str = dateFormatOut.format(date).toUpperCase();
        System.out.println(str);
    }
}
