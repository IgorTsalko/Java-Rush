package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        byte numOne = scan.nextByte();
        byte numTwo = scan.nextByte();
        byte numThree = scan.nextByte();
        scan.close();

        checkCouple(numOne, numTwo, numThree);
    }
    public static void checkCouple (byte numOne, byte numTwo, byte numThree) {
        if (numOne == numTwo && numTwo == numThree)
            System.out.println(numOne + " " + numTwo + " " + numThree);
        else if (numTwo == numThree)
            System.out.println(numTwo + " " + numThree);
        else if (numOne == numTwo)
            System.out.println(numOne + " " + numTwo);
        else if (numOne == numThree)
            System.out.println(numOne + " " + numThree);
    }
}