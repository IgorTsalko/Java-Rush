package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream source;

    public QuestionFileOutputStream(AmigoOutputStream source) {
        this.source = source;
    }

    @Override
    public void flush() throws IOException {
        source.flush();
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
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (reader.readLine().equals("Д")) {
            source.close();
        }
    }
}

