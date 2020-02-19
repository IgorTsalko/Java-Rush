package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("мама");
        arr.add("мыла");
        arr.add("раму");

        for (int i = 1; i <= 5; i += 2) {
            arr.add(i,"именно");
        }


        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
