package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private String state;
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (thread.getState().name().equals(state)) {
                continue;
            } else {
                state = thread.getState().name();
            }
            switch (state) {
                case "NEW":
                    System.out.println("NEW");
                    break;
                case "RUNNABLE":
                    System.out.println("RUNNABLE");
                    break;
                case "BLOCKED":
                    System.out.println("BLOCKED");
                    break;
                case "WAITING":
                    System.out.println("WAITING");
                    break;
                case "TIMED_WAITING":
                    System.out.println("TIMED_WAITING");
                    break;
                case "TERMINATED":
                    System.out.println("TERMINATED");
                    interrupt();
                    break;
            }
        }
    }
}
