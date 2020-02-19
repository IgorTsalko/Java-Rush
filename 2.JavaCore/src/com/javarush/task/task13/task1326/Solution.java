package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner fileName = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(fileName.nextLine());
        BufferedReader in = new BufferedReader(new InputStreamReader(fileInputStream));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String line;

        while ((line = in.readLine()) != null) {
            arrayList.add(Integer.parseInt(line));
        }

        Collections.sort(arrayList);

        for (Integer i : arrayList) {
            if (i %2 == 0)
                System.out.println(i);
        }

        in.close();
        fileInputStream.close();
    }
}
