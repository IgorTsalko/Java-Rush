package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[] order = {5, 2, 4, 7, 0};

        for (int i : order) {
            int[] arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = i + 25 - j * 3;
            }
            arrayList.add(arr);
        }

        return arrayList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
