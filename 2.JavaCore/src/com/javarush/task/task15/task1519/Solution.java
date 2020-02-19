package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Number num = null;

        while (!(str = reader.readLine()).equals("exit")) {
            try {
                num = NumberFormat.getInstance().parse(str);
            } catch (ParseException e) {
                print(str);
                continue;
            }

            if (str.contains(".")) {
                print(Double.parseDouble(str));
            } else if (num.intValue() > 0 && num.intValue() < 128) {
                print(Short.parseShort(str));
            } else if (num.intValue() <= 0 || num.intValue() >= 128) {
                print(num.intValue());
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
