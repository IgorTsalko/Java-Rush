package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();

        if (firstName.equals(secondName))
            System.out.println("Имена идентичны");
        else if (firstName.length() == secondName.length())
            System.out.println("Длины имен равны");
    }
}
