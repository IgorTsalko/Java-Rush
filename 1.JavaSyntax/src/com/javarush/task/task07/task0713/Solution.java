package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> divideThree = new ArrayList<>();
        ArrayList<Integer> divideTwo = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 3 == 0 && arr.get(i) % 2 == 0) {
                divideThree.add(arr.get(i));
                divideTwo.add(arr.get(i));
            } else if (arr.get(i) % 3 == 0)
                divideThree.add(arr.get(i));
            else if (arr.get(i) % 2 == 0)
                divideTwo.add(arr.get(i));
            else
                other.add(arr.get(i));
        }

        printList(divideThree);
        printList(divideTwo);
        printList(other);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
