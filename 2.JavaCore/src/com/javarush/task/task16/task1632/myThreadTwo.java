package com.javarush.task.task16.task1632;

public class myThreadTwo extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
