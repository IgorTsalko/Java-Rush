package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            strs.add(reader.readLine());
        }

        for (int i = 1; i <= 13; i++) {
            String str = strs.get(strs.size() - 1);
            strs.remove(strs.size() - 1);
            strs.add(0, str);
        }

        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    }
}
