package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = buffer.readLine();
        int num = Integer.parseInt(buffer.readLine());

        while (num > 0) {
            num--;
            System.out.println(str);
        }
    }
}
