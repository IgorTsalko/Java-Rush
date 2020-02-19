package com.javarush.task.task16.task1632;

public class myThreadThree extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
        }
    }
}
