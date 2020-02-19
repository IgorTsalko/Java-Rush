package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(2.3, "Куст");
        labels.put(1.8, "Home");
        labels.put(8.3, "Wood");
        labels.put(4.1, "Table");
        labels.put(9.3, "Chair");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
