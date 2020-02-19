package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        while (true) {
            try {
                name = reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try(FileInputStream in = new FileInputStream(name)) {

            } catch (FileNotFoundException fnf) {
                System.out.println(name);
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
