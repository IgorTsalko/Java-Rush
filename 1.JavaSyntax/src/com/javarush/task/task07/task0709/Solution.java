package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrlist = new ArrayList<>();

        arrlist.add(reader.readLine());
        arrlist.add(reader.readLine());
        arrlist.add(reader.readLine());
        arrlist.add(reader.readLine());
        arrlist.add(reader.readLine());

        for (int i = 0; i < arrlist.size() - 1; i++) {
            for (int j = i+1; j < arrlist.size(); j++) {
                if (arrlist.get(i).length() > arrlist.get(j).length()) {
                    String str = arrlist.get(j);
                    arrlist.set(j, arrlist.get(i));
                    arrlist.set(i, str);
                    }
                }
            }
        System.out.println(arrlist.get(0));
        for (int i = 1; i < arrlist.size(); i++) {
            if (arrlist.get(0).length() == arrlist.get(i).length())
            System.out.println(arrlist.get(i));
        }
    }
}
