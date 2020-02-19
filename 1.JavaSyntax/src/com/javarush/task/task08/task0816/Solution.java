package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 5 2012"));
        map.put("Пит", dateFormat.parse("APRIL 12 1988"));
        map.put("Бенедик", dateFormat.parse("JANUARY 4 1998"));
        map.put("Вектор", dateFormat.parse("FEBRUARY 8 1948"));
        map.put("Копчик", dateFormat.parse("MARCH 16 1958"));
        map.put("Вестик", dateFormat.parse("MAY 9 1998"));
        map.put("Констик", dateFormat.parse("JUN 30 1968"));
        map.put("Гамбиг", dateFormat.parse("JULY 16 1985"));
        map.put("Путин", dateFormat.parse("AUGUST 26 1995"));
        map.put("Кетрон", dateFormat.parse("SEPTEMBER 28 1967"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth();
            if (month > 4 && month < 8)
                iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
    }
}
