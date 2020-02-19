package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        Object result;
        int start = url.indexOf("?")+1;
        int end;

        while (true) {
            if (url.indexOf("=", start) < url.indexOf("&", start))
                end = url.indexOf("=", start);
            else
                end = url.indexOf("&", start);

            if (end == -1) {
                System.out.println(url.substring(start, url.indexOf("=", start)));
                break;
            } else
                System.out.print(url.substring(start, end) + " ");

            start = url.indexOf("&", end)+1;
        }

        if (url.contains("obj")) {
            String str = url.substring(url.lastIndexOf("obj=")+4, url.indexOf("&"));
            try {
                double d = Double.parseDouble(str);
                alert(d);
            } catch (Exception e) {
                alert(str);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
