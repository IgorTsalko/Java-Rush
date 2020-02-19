package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> arrStr = new ArrayList<>();

        arrStr.add("Hello");
        arrStr.add("World");
        arrStr.add("How");
        arrStr.add("Are");
        arrStr.add("You?");

        System.out.println(arrStr.size());

        for (int i = 0; i < arrStr.size(); i++) {
            System.out.println(arrStr.get(i));
        }
    }
}
