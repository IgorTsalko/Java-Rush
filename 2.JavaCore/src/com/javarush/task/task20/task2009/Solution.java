package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 10;
        classWithStatic.j = 18;
        ClassWithStatic copyFile = null;

        try {
            serializeFile(classWithStatic);
            copyFile = deserializeFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(copyFile.i);
        System.out.println(copyFile.j);

    }

    public static void serializeFile(ClassWithStatic file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:/Java/Files/firstFile.txt"));
        out.writeObject(file);
    }

    public static ClassWithStatic deserializeFile() throws IOException, ClassNotFoundException {
        return (ClassWithStatic) new ObjectInputStream(new FileInputStream("E:/Java/Files/firstFile.txt")).readObject();
    }
}
