package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String name = buffer.readLine();
        int year = Integer.parseInt(buffer.readLine());
        int month = Integer.parseInt(buffer.readLine());
        int day = Integer.parseInt(buffer.readLine());

        System.out.println("Меня зовут " + name + ".");
        System.out.print("Я родился " + day + "." + month + "." + year);
    }
}
