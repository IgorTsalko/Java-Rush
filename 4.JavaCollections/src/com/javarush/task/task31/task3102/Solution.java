package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        File file = new File(root);
        queue.add(file);

        while (!queue.isEmpty()) {
            file = queue.element();
            queue.remove(file);

            if (file.isDirectory()) {
                queue.addAll(Arrays.asList(file.listFiles()));
            } else {
                list.add(file.getAbsolutePath());
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileTree = getFileTree("E:/Java/Files2/");

        for (String path : fileTree) {
            System.out.println(path);
        }
    }
}
