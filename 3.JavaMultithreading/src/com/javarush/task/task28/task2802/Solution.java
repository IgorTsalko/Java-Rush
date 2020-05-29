package com.javarush.task.task28.task2802;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/
public class Solution {
    static AtomicInteger factoryNumber = new AtomicInteger(1);

    public static void main(String[] args) {

        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        AtomicInteger threadNumber = new AtomicInteger(1);
        int facNumber = factoryNumber.getAndIncrement();
        @Override
        public Thread newThread(Runnable r) {
            String threadGroupName = Thread.currentThread().getThreadGroup().getName();
            Thread thread = new Thread(r, String.format("%s-pool-%d-thread-%d",
                    threadGroupName, facNumber, threadNumber.getAndIncrement()));
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }
}
