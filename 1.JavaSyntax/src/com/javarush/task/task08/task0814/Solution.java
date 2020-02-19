package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();

        set.add(5);
        set.add(42);
        set.add(582);
        set.add(47);
        set.add(8);
        set.add(7);
        set.add(85);
        set.add(9);
        set.add(25);
        set.add(3);
        set.add(1);
        set.add(542);
        set.add(6);
        set.add(4);
        set.add(784);
        set.add(96);
        set.add(72);
        set.add(0);
        set.add(387);
        set.add(452);

        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() > 10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
