package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, File> files = new TreeMap<>();

        File directory = new File(args[0]);
        File resultFile = new File(args[1]);
        File newNameFile = new File(resultFile.getParent() + "\\allFilesContent.txt");

        FileInputStream in;

        FileUtils.renameFile(resultFile, newNameFile);
        FileOutputStream out = new FileOutputStream(newNameFile);

        checkDirectory(directory, files);

        byte[] buff;
        for (Map.Entry<String, File>  f: files.entrySet()) {
            in = new FileInputStream(f.getValue());

            try {
                buff = new byte[in.available()];
                in.read(buff);
                out.write(buff);
                out.write("\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkDirectory(File file, Map<String, File> files) {
        File[] names = file.listFiles();

        for (File f : names) {
            if (f.isDirectory()) {
                checkDirectory(f, files);
            } else {
                if (f.length() <= 50) {
                    files.put(f.getName(), f);
                }
            }
        }
    }
}
