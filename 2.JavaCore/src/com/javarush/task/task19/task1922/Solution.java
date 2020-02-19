package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }
//    E:/Java/Files/fourthFile.txt
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader in = new BufferedReader(new FileReader(reader.readLine()))) {
            while (in.ready()) {
                String line = in.readLine();
                String[] lineInArray = line.split(" ");
                int count = 0;
                for (String wordInFile : lineInArray) {
                    for (String wordInList : words) {
                        if (wordInFile.equals(wordInList)) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
