package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static int strMax = 0;
    public static int strMin;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            strs.add(reader.readLine());
        }

        for (int i = 0; i < strs.size(); i++) {
            if (strMax < strs.get(i).length())
                strMax = strs.get(i).length();
        }

        for (int i = 0; i < strs.size(); i++) {
            if (i == 0)
                strMin = strs.get(0).length();
            if (strMin > strs.get(i).length())
                strMin = strs.get(i).length();
        }

        for (int i = 0; i < strs.size(); i++) {
            if (strs.get(i).length() == strMax) {
                System.out.println(strs.get(i));
                break;
            }
            if (strs.get(i).length() == strMin) {
                System.out.println(strs.get(i));
                break;
            }
        }
    }
}
