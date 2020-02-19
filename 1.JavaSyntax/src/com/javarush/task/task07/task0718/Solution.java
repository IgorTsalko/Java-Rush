package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> arrSize = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        for (String i : strings) {
            arrSize.add(i.length());
        }

        for (int i = 0; i < arrSize.size() - 1; i++) {
            for (int j = i + 1; j < arrSize.size(); j++) {
                if (arrSize.get(i) > arrSize.get(j)) {
                    int copy = arrSize.get(j);
                    arrSize.set(j, arrSize.get(i));
                    arrSize.set(i, copy);
                }
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() != arrSize.get(i)) {
                System.out.println(i+1);
                break;
            }
        }
    }
}

