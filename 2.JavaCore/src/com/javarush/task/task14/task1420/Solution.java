package com.javarush.task.task14.task1420;
import java.io.*;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(reader.readLine());
        int secondNum = Integer.parseInt(reader.readLine());
        if (firstNum <= 0 || secondNum <= 0) {
            throw new Exception();
        }
        int NOD = findNOD(firstNum, secondNum);
        System.out.println(NOD);
    }

    static int findNOD(int firstNum, int secondNum) {
        int numLess = 0;
        int numMore = 0;
        int NOD;

        if (firstNum > secondNum) {
            numMore = firstNum;
            numLess = secondNum;
        } else if (firstNum < secondNum) {
            numMore = secondNum;
            numLess = firstNum;
        } else if (firstNum == secondNum) {
            return firstNum;
        }

        if (numMore %numLess == 0)
            return numLess;

        int factor = numLess;
        while (factor >= 1) {
            factor--;
            if (numLess %factor == 0)
                if (numMore %factor == 0)
                    return factor;
        }
        return 0;
    }
}
