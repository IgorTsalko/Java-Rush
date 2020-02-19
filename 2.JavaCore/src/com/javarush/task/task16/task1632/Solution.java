package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new myThreadOne());
        threads.add(new myThreadTwo());
        threads.add(new myThreadThree());
        threads.add(new myThreadFour());
        threads.add(new myThreadFive());
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}