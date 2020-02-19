package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder data = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));
            String str;
            while ((str = in.readLine()) != null) {
                data.append(str);
            }
            Pattern pattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                out.write(matcher.group() + " ");
            }
            reader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    E:/Java/Files/firstFile.txt
}
