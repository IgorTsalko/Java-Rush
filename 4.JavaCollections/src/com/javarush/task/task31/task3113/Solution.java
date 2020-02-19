package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(reader.readLine());
        MyFileVisitor fileVisitor = new MyFileVisitor();

        if (Files.isDirectory(directory)) {
            Files.walkFileTree(directory, fileVisitor);
            System.out.println("Всего папок - " + fileVisitor.getCountOfDirectory());
            System.out.println("Всего файлов - " + fileVisitor.getCountOfFiles());
            System.out.println("Общий размер - " + fileVisitor.getCountOfBytes());
        } else {
            System.out.println(directory.toString() + " - не папка");
        }
        reader.close();
    }
}
