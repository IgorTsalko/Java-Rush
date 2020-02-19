package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class myThreadFive extends Thread {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        String line;
        int sum = 0;
        while (true) {
            try {
                line = reader.readLine();
                if (line.equals("N")) {
                    reader.close();
                    break;
                } else
                    sum += Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sum);
}


}
