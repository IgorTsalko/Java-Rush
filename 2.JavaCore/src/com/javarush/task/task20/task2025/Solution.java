package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long[][] degreeTable = new long[10][20];
    private static long LONG_N = Long.MAX_VALUE;

    static {
        //  long start  = System.currentTimeMillis();

        for (int j = 0; j < degreeTable[0].length; j++) {
            degreeTable[0][j] = 0;
        }

        for (int j = 0; j < degreeTable[0].length; j++) {
            degreeTable[1][j] = 1;
        }

        for (int i = 2; i < degreeTable.length; i++) {
            for (int j = 1; j < degreeTable[0].length; j++) {
                degreeTable[i][j] = i;
                for (int k = 1; k < j; k++) {
                    degreeTable[i][j] *= i;
                }
            }
        }
        // long end = System.currentTimeMillis() - start;
        // SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
        // System.out.println("Время создания массива: " + pattern.format(new Date(end)));
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getNumbers(1000)));
//        System.out.println(Arrays.toString(getNumbers(100)));

//        long start  = System.currentTimeMillis();
//        long[] result = getNumbers(LONG_N);
//        long end = System.currentTimeMillis() - start;
//        SimpleDateFormat pattern = new SimpleDateFormat("ss.SSS");
//        System.out.println("Время обработки чисел: " + pattern.format(new Date(end)));

        long startTime = System.currentTimeMillis();
        long[] armstrong = getNumbers(Long.MAX_VALUE);
        double time = (System.currentTimeMillis() - startTime) / 1000.0;
        double usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576.0;
        System.out.println("Затрачено на всю задачу " + time + " сек, и " + usedMemory + " мб.");
        System.out.println("Числа Армстронга:");
        System.out.println(Arrays.toString(armstrong));
//        checkArmstrongNumbers(armstrong);
        System.out.println("Всего чисел: " + armstrong.length);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
    }

    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();
        if (N > 0 && N <= Long.MAX_VALUE ){
            long currentNumber = 1;
            long sumCurrentNumber;
            while (currentNumber < N && currentNumber != -1){
                //System.out.println("curN=" + currentNumber);
                int currentNumberSize = String.valueOf(currentNumber).length();
                int endNumberSize = String.valueOf(N).length();
                for (int i = currentNumberSize; i <= endNumberSize; i++) {
                    sumCurrentNumber = getNumberSum(currentNumber, i, false);
                    if (sumCurrentNumber < currentNumber) continue;

                    if (isArmstrong(sumCurrentNumber) && sumCurrentNumber < N){
                        if (!list.contains(sumCurrentNumber)) list.add(sumCurrentNumber);
                        //System.out.println(sumCurrentNumber + " " + currentNumber + " " + i);
                    }
                }
                currentNumber = getNextNumber(currentNumber);
            }
        }
        long[] result = new long[list.size()];
        Collections.sort(list);

        // long[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
       /* for (int i = 0; i < result.length; i++) {
            if (result[i] != temp[i]) System.out.println(result[i] + " не равно" + temp[i]);
            else System.out.println("Равно");
        }*/
        return result;
    }

    private static long getNextNumber(long currentNumber){
        if (currentNumber % 10 == 9){
            currentNumber++;
            int countZero = 0;
            long index;
            while ((index = currentNumber % 10) == 0) {
                countZero++;
                currentNumber /= 10;
            }
            StringBuffer sbNumber = new StringBuffer(Long.toString(currentNumber));
            for (int i = 0; i < countZero; i++) sbNumber.append(index);
            try {
                currentNumber = Long.valueOf(sbNumber.toString());
            } catch (NumberFormatException e){
                currentNumber = Long.MAX_VALUE;
            }

        } else{
            currentNumber++;
        }

        if (currentNumber == Long.MAX_VALUE) return -1;
        return currentNumber;
    }

    private static boolean isArmstrong(long number){
        long num = getNumberSum(number, String.valueOf(number).length(), true);
        if (num == number){
            return true;
        }
        return false;
    }

    private static long getNumberSum(long number, int degree, boolean checkResult){
        long result = 0;
        long defaultNumber = number;
        int index;

        while (number > 0) {
            index = (int) (number % 10);
            result += degreeTable[index][degree];
            if (checkResult && result > defaultNumber) return -1;
            number /= 10;
        }
        return result;
    }
}

//import java.util.*;

/*
Алгоритмы-числа
*/
//
//
//public class Solution {
//    private static long[][] powMatrix = new long[10][21];
//
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        long[] armstrong = getNumbers(Long.MAX_VALUE);
//        double time = (System.currentTimeMillis() - startTime) / 1000.0;
//        double usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576.0;
//        System.out.println("Затрачено на всю задачу " + time + " сек, и " + usedMemory + " мб.");
//        System.out.println("Числа Армстронга:");
//        System.out.println(Arrays.toString(armstrong));
//        checkArmstrongNumbers(armstrong);
//        System.out.println("Всего чисел: " + armstrong.length);
//    }
//
//    public static long[] getNumbers(long N) {
//        long[] arr = null;
//        if (N > 0 && N <= Long.MAX_VALUE) {
//            ArrayList<Long> numbers = new ArrayList<>();
//            Set<Long> armstrongNumbers = new TreeSet<>();
//
//            generateSuitableNumbers(N, numbers);
//            generatePowMatrix();
//
//            for (long n : numbers) {
//                for (int i = 1; i <= 1000 ; i *= 10) {
//                    long number = n*i;
//                    if (number < 0) {
//                        break;
//                    }
//                    long a = powerSum(number);
//                    if (a < 0) {
//                        break;
//                    }
//                    if (n == a) {
//                        armstrongNumbers.add(n);
//                    } else if (a == powerSum(a)) {
//                        armstrongNumbers.add(a);
//                    }
//                }
//            }
//            long[] result = new long[armstrongNumbers.size()];
//
//            int count = 0;
//            for (long l : armstrongNumbers) {
//                result[count++] = l;
//            }
//            arr = result;
//        }
//        return arr;
//    }
//
//    /**
//     * Генерирует числа, до N, учитывая что последующая цифра должна быть не меньше
//     * предшестующей.
//     *
//     * @param N число, до которого, исключая его, нужно найти все числа Армстронга.
//     */
//    private static void generateSuitableNumbers(long N, ArrayList<Long> numbers) {
//        putNumbersFrom0To9(numbers);
//
//        long n = 10;
//        String stringNumber = String.valueOf(n);
//        int position;
//        int i = 1;
//
//        while (n < N) {
//            position = stringNumber.length() - 1;
//            for (; i < 10; i++) {
//                stringNumber = stringNumber.substring(0, position) + i;
//                n = Long.parseLong(stringNumber);
//                numbers.add(n);
//            }
//
//            position = stringNumber.indexOf("9");
//            if (position - 1 > 0) { // 1199 to 1222
//                stringNumber = stringNumber.substring(0, position - 1)
//                        + newAddNumber(stringNumber.substring(position - 1));
//            } else if (position - 1 == 0) { // 199 to 222
//                stringNumber = newAddNumber(stringNumber);
//            } else if (position == 0) { // 999 to 1111
//                stringNumber = newExponentNumber(stringNumber);
//            }
//
//            try {
//                n = Long.parseLong(stringNumber);
//                numbers.add(n);
//            } catch (NumberFormatException e) {
//                break;
//            }
//
//            i = Integer.parseInt(stringNumber.substring(stringNumber.length() - 1)) + 1;
//        }
//    }
//
//    /**
//     * Помещаем в массив предварительно собраных чисел, числа от 1 до 9,
//     * так как они являются числами Армстронга.
//     */
//    private static void putNumbersFrom0To9(ArrayList<Long> numbers) {
//        for (int i = 1; i < 10; i++) {
//            numbers.add((long) i);
//        }
//    }
//
//    /**
//     * @param stringNumber передаем число, состоящее только из девяток,
//     *                     чтобы сделать из него число на порядок больше.
//     *                     Например из 999 в 1111.
//     * @return возвращает преобразованное число строкой.
//     */
//    private static String newExponentNumber(String stringNumber) {
//        StringBuilder buff = new StringBuilder();
//        for (int i = 0; i < stringNumber.length() + 1; i++) {
//            buff.append(1);
//        }
//        return new String(buff);
//    }
//
//    /**
//     * @param stringNumber передаем число, первую цифру которого нужно увеличить,
//     *                     а послеющие сделать такими же, как первое, увеличенное число.
//     *                     Например: 199 в 222.
//     * @return возвращает преобразованное число строкой.
//     */
//    private static String newAddNumber(String stringNumber) {
//        StringBuilder buff = new StringBuilder();
//        String n = String.valueOf(Integer.parseInt(stringNumber.substring(0, 1)) + 1);
//        for (int i = 0; i < stringNumber.length(); i++) {
//            buff.append(n);
//        }
//        return new String(buff);
//    }
//
//    /**
//     * Возвращает степенную сумму числа
//     * @param n Любое long число
//     * @return степенную сумму числа
//     */
//    private static long powerSum(long n) {
//        int power = Long.toString(n).length();
//        long result = 0;
//        int letter;
//        while (n != 0) {
////            result += pow((int) (n%10), power);
//            letter = (int) (n % 10);
//            if (letter < 0) {
//                break;
//            }
//            result += powMatrix[letter][power];
//
//            n = n/10;
//        }
//        return result;
//    }
//
//    /**
//     * Генерируем матрицу степеней, работает вместе с pow()
//     */
//    private static void generatePowMatrix() {
//        for (int i = 1; i < powMatrix.length; i++) {
//            for (int j = 1; j < powMatrix[i].length; j++) {
//                powMatrix[i][j] = pow(i, j);
//            }
//        }
//    }
//
//    static long pow(int a, int b){
//        long result = 1;
//        if (a == 0) {
//            return 0;
//        }
//        if (a == 1) {
//            return 1;
//        }
//        for (int i = 1; i <= b; i++){
//            result = result*a;
//        }
//        return result;
//    }
//
//
//
//
//    /**
//     * Ниже код для проверки
//     *
//     */
//
//    private static void checkArmstrongNumbers(long[] numbers) {
//         long[] armstrongNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
////        long[] armstrongNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
////                548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
////                472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
////                42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
////                4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
////                1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
//
//        for (int i = 0; i < armstrongNumbers.length; i++) {
//            if (numbers[i] != armstrongNumbers[i]) {
//                System.out.println("Числа Армстронга несовпадают");
//                break;
//            }
//        }
//    }
//
//    private static void checkNumbers(ArrayList<Long> numbers) {
//        for (long l : numbers) {
//            if (!checkNumber(l)) {
//                System.out.println("Неверное число! " + l);
//            }
//        }
//    }
//
//    private static boolean checkNumber(long l) {
//        String stringLong = String.valueOf(l);
//        for (int i = 0; i < stringLong.length() - 1; i++) {
//            int a = Integer.parseInt(stringLong.substring(i, i+1));
//            int b = Integer.parseInt(stringLong.substring(i+1, i+2));
//            if (a > b) {
//                return false;
//            }
//        }
//        return true;
//    }
//}