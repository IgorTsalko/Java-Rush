package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");

    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    deleteRectangle(i, j, a);
                }
            }
        }
        return count;
    }

    private static void deleteRectangle(int i, int j, byte[][] rectangle) {
        int start = j;
        do {
            if (rectangle[i][j] == 1) {
                rectangle[i][j++] = 0;
            } else {
                i++;
                j = start;
                try {
                    if (rectangle[i][j] == 0) {
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        } while (i < rectangle.length && j < rectangle[i].length);
    }
}
