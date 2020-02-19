package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ExpandableArray array = new ExpandableArray();
        int count = 0;
        try {
            Reader in = new FileReader(reader.readLine());
            while (in.ready()) {
                array.putValue((byte)in.read());
            }
            String data = new String(array.getArray()).trim();
            Pattern pattern = Pattern.compile("\\b[Ww]orld\\b");
            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                count++;
            }
            System.out.println(count);
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//        E:/Java/Files/firstFile.txt
//        E:/Java/Files/fourthFile.txt