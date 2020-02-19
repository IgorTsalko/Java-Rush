package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
            Pattern pattern = Pattern.compile("\\d");

            while (in.ready()) {
                String[] line = in.readLine().split(" ");
                for (String word : line) {
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        out.write(word + " ");
                    }
                }
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
