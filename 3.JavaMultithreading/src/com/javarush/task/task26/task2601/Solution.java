package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] a = {13, 8, 15, 5, 17, 7};
//        System.out.println((Arrays.toString(sort(a))));
    }

    public static Integer[] sort(Integer[] array) {
        double median;
        Integer[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(result);

        if (result.length %2 == 0) {
            median = (result[result.length/2 - 1] + result[result.length/2]) / 2.0;
        } else {
            median = result[result.length/2];
        }

        Comparator<Integer> medianCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(median - o1) < Math.abs(median - o2)) {
                    return -1;
                } else if (Math.abs(median - o1) > Math.abs(median - o2)) {
                    return 1;
                }
                return 0;
            }
        };
        Arrays.sort(result, medianCompare);
        System.out.println("3. In the method " + Arrays.toString(result));
        return result;
    }
}
