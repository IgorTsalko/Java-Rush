package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));

            int count = 0;
            while (in.ready()) {
                String[] line = in.readLine().split(" ");
                for (String word : line) {
                    if (word.length() > 6) {
                        if (count++ > 0) {
                            out.write("," + word);
                        } else
                            out.write(word);
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
