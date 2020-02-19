package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, ByteArrayOutputStream> data = new HashMap<>();
        String newPathInArchive = "new\\" + Paths.get(args[0]).getFileName();

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry fileInArchive;
            ByteArrayOutputStream byteOut;
            while ((fileInArchive = zipIn.getNextEntry()) != null) {
                if (fileInArchive.getName().endsWith(Paths.get(args[0]).getFileName().toString())) {
                    newPathInArchive = fileInArchive.getName();
                } else {
                    byteOut = new ByteArrayOutputStream();
                    int length;
                    byte[] buffer = new byte[1024];
                    while ((length = zipIn.read(buffer)) != -1) {
                        byteOut.write(buffer, 0, length);
                    }
                    data.put(fileInArchive.getName(), byteOut);
                    zipIn.closeEntry();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]))) {
            zipOut.putNextEntry(new ZipEntry(newPathInArchive));
            Files.copy(Paths.get(args[0]), zipOut);
            for (Map.Entry<String, ByteArrayOutputStream> pair : data.entrySet()) {
                zipOut.putNextEntry(new ZipEntry(pair.getKey()));
                zipOut.write(pair.getValue().toByteArray());
                zipOut.closeEntry();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
