package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            strings.add(reader.readLine());
        }

        for (int i = 0; i < m; i++) {
            strings.add(strings.size(), strings.get(0));
            strings.remove(strings.get(0));
        }

        for (String i : strings) {
            System.out.println(i);
        }
    }
}
