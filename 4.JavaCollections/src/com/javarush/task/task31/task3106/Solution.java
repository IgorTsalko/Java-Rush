package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

//E:\Java\testFolder\Files2\result.txt E:\Java\testFolder\Files2\test.z01 E:\Java\testFolder\Files2\test.z02 E:\Java\testFolder\Files2\test.z03
public class Solution {
    public static void main(String[] args) {
        Set<String> files = new TreeSet<>();
        Vector<InputStream> vectorFiles = new Vector<>(args.length - 1);

        try {
            for (int i = 1; i < args.length; i++) {
                files.add(args[i]);
            }
            for (String name : files) {
                vectorFiles.addElement(new FileInputStream(name));
            }
            ZipInputStream zin = new ZipInputStream(new SequenceInputStream(vectorFiles.elements()));
            FileOutputStream out = new FileOutputStream(args[0]);
            ZipEntry entry = zin.getNextEntry();
            int length;
            byte[] buff = new byte[1024];
            while ((length = zin.read(buff)) != -1) {
                out.write(buff, 0, length);
            }
            out.flush();
            zin.closeEntry();
            zin.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
