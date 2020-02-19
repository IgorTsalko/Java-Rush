package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String path;

    public Solution(String fileName) throws FileNotFoundException {
        path = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.writeObject(path);
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        path = (String) in.readObject();
        stream = new FileOutputStream(path, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
            Solution solution = new Solution("instance.txt");
            solution.writeObject("test String");
            out.writeObject(solution);

            Solution solution1 = (Solution) in.readObject();
            solution.writeObject("string two");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
