package com.javarush.task.task16.task1632;

public class myThreadFour extends Thread implements Message {
    @Override
    public void showWarning() {
        interrupt();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
