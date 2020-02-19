package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        int count = 1;
        while (true) {
            System.out.println("Print: " + count++);
            try {
                runner.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread thread = new Thread(this);
        runner = thread;
        runner.start();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(10);

        try {
            Thread.sleep(5000);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:/Java/Files/firstFile.txt"));
            out.writeObject(solution);

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/Java/Files/firstFile.txt"));
            Solution solution1 = (Solution) in.readObject();
        } catch (IOException | InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
