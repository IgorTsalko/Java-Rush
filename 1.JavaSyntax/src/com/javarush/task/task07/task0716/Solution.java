package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> strs = strings;
        for (int i = 0; i < strs.size();) {
            if (strs.get(i).contains("р") && !(strs.get(i).contains("л"))) {
                strs.remove(i);
            }
            else if (strs.get(i).contains("л") && !(strs.get(i).contains("р"))) {
                strs.add(i, strs.get(i));
                i += 2;
            } else
                i++;
        }
        return strs;
    }
}