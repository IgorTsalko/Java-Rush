package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public synchronized static IMF getFund() {
            if (imf != null) {
                return imf;
            } else {
                imf = new IMF();
                return imf;
            }
    }

    private IMF() {
    }
}
