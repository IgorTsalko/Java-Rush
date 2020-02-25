package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread : threads) {
            String state = thread.getState().name();
             switch (state) {
                 case "NEW":
                     thread.start();
                     break;
                 case "WAITING":
                 case "TIMED_WAITING":
                 case "BLOCKED":
                     thread.interrupt();
                     break;
                 case "RUNNABLE":
                     thread.isInterrupted();
                     break;
                 case "TERMINATED":
                     System.out.println(thread.getPriority());
                     break;
             }
        }
    }

    public static void main(String[] args) {

    }
}


