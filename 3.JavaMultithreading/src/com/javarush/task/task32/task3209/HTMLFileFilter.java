package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else
            return file.getName().toLowerCase().endsWith(".html")
                    || file.getName().toLowerCase().endsWith(".htm");
    }

    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
