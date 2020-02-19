package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

//    E:/Java/Files/firstFile.txt
//    E:/Java/Files/secondFile.txt
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
                BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            String strFile1 = file1.readLine();
            String strFile2 = file2.readLine();
            String tmp;
            while (file1.ready() && file2.ready()) {
                if (strFile1.equals(strFile2)) {
                    lines.add(new LineItem(Type.SAME, strFile2));
                    strFile1 = file1.readLine();
                    strFile2 = file2.readLine();
                } else if ((tmp = file1.readLine()).equals(strFile2)){
                    lines.add(new LineItem(Type.REMOVED, strFile1));
                    lines.add(new LineItem(Type.SAME, strFile2));
                    strFile1 = file1.readLine();
                    strFile2 = file2.readLine();
                } else if (strFile1.equals(file2.readLine())) {
                    lines.add(new LineItem(Type.ADDED, strFile2));
                    lines.add(new LineItem(Type.SAME, strFile1));
                    strFile1 = tmp;
                    strFile2 = file2.readLine();
                }
            }
            if (strFile1 == null) {
                lines.add(new LineItem(Type.ADDED, strFile2));
            } else if (strFile2 == null) {
                lines.add(new LineItem(Type.REMOVED, strFile1));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
