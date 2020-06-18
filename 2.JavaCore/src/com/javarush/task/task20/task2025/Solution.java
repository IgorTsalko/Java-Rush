package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/

public class Solution {
    private static long[][] powMatrix = new long[10][21];

    static {
        // Генерируем матрицу степеней
        generatePowMatrix();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        long[] armstrong = getNumbers(Long.MAX_VALUE);

        double time = (System.currentTimeMillis() - startTime) / 1000.0;
        double usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576.0;
        System.out.printf("Затрачено на всю задачу %.2f сек; Памяти: %.2f мб.\n", time, usedMemory);
        System.out.println("Числа Армстронга:");
        System.out.println(Arrays.toString(armstrong));
        checkArmstrongNumbers(armstrong);
        System.out.println("Всего чисел: " + armstrong.length);
    }

    public static long[] getNumbers(long N) {
        // Чисел армстронга в промежутке от 0 до Long.MAX_VALUE - 50
        long[] armstrongNumbers = new long[50];
        if (N > 0 && N <= Long.MAX_VALUE) {
            // Заполняем список числами армстронга
            List<Long> numbers = findArmstrongNumbers();
            // Сортируем по возрастанию
            Collections.sort(numbers);

            int count = 0;
            for (long l : numbers) {
                armstrongNumbers[count++] = l;
            }
        }
        return armstrongNumbers;
    }

    // Находим и возращаем числа армстронга
    private static List<Long> findArmstrongNumbers() {
        List<Long> armstrongNumbers = new ArrayList<>();
        long num = 0;

        while (num >= 0) {
            if (num % 10 == 9) {
                // Если число с окончанием 9 - нужно получить правильное, согласно алгоритму
                num = getRightNumber(num);
            } else {
                num++;
            }

            /*
            Проверяем полученное число, а так же число с добавением 1-го, 2-ух и 3-ех
            нулей в конце на соответсвите числу Армстронга
             */
            for (int i = 1; i <= 1000 ; i *= 10) {
                long number = num * i;
                // Если число, число Армстронга, добавляем его, если его еще нет в листе.
                isArmstrongAddIt(number, armstrongNumbers);
            }
        }
        return armstrongNumbers;
    }

    // Если число, число Армстронга, добавляем его, если его еще нет в листе.
    private static void isArmstrongAddIt(long num, List<Long> numbers) {
        if (num < 0) {
            return;
        }
        long armstrongNum;
        
        long a = powerSum(num);
        if (a < 0) {
            return;
        }

        if (a == num) {
            armstrongNum = num;
        } else if (a == powerSum(a)) {
            armstrongNum = a;
        } else {
            return;
        }

        if (!numbers.contains(armstrongNum)) {
            numbers.add(armstrongNum);
        }
    }

    // Получаем правильное число для поиска чисел Армстронга. 19 -> 22, 199 -> 222 ...
    private static long getRightNumber(long num) {
        int count = 1;
        long tail;
        while (true) {
            tail = (num % 10);
            if (tail != 9) {
                num -= tail;
                tail++;
                num += tail;
                break;
            }
            count++;
            num -= 9;
            num /= 10;
        }
        for (int i = 1; i < count; i++) {
            num *= 10;
            num += tail;
        }
        return num;
    }

    /**
     * Возвращает степенную сумму числа
     *
     * @param n Любое long число
     * @return степенную сумму числа
     */
    private static long powerSum(long n) {
        int length = Long.toString(n).length();
        if (length < 2) {
            return n;
        }

        long result = 0;
        while (true) {
            int numeral = (int) (n % 10);
            result += powMatrix[numeral][length];

            if (n < 10) {
                break;
            }

            n = n / 10;
        }
        return result;
    }

    /**
     * Генерируем матрицу степеней, работает вместе с pow()
     */
    private static void generatePowMatrix() {
        for (int i = 1; i < powMatrix.length; i++) {
            for (int j = 1; j < powMatrix[i].length; j++) {
                powMatrix[i][j] = pow(i, j);
            }
        }
    }

    static long pow(int a, int b) {
        long result = 1;
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    /**
     * Ниже код для проверки
     */
    private static void checkArmstrongNumbers(long[] numbers) {
        long[] armstrongNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        for (int i = 0; i < armstrongNumbers.length; i++) {
            if (numbers[i] != armstrongNumbers[i]) {
                System.out.println("Числа Армстронга не совпадают");
                System.out.println(numbers[i] + " != " + armstrongNumbers[i]);
                break;
            }
        }
    }
}