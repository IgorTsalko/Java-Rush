package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream source;
    private static String str = "JavaRush © All rights reserved.";

    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream source) throws FileNotFoundException {
        super(fileName);
        this.source = source;
    }

    @Override
    public void write(int b) throws IOException {
        source.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        source.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        source.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        source.flush();
    }

    @Override
    public void close() throws IOException {
        this.flush();
//        this.write(str.getBytes(), 0, str.length());
        this.write(str.getBytes());
        source.close();
    }
}
