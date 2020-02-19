package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                result.append(pair.getKey() + " = \'" + pair.getValue() + "\' and ");
            }
        }
        if (result.length() < 1) {
            return "";
        }
        return result.substring(0, result.lastIndexOf(" and "));
    }
}
