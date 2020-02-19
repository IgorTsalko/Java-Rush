package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayList = new ArrayList<>();
        int sequence = 0;

        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j)))
                    count++;
                else
                    break;
            }
            if (sequence < count)
                sequence = count;
        }

        System.out.println(sequence);
    }
}