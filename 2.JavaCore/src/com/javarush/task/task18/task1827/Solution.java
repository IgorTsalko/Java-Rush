package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
//        E:/Java/Files/firstFile.txt
//        -c Geofox mid743 239.00 28
        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileOutputStream out = new FileOutputStream(fileName, true);
            float price = Float.parseFloat(args[args.length - 2].trim());
            int quantity = Integer.parseInt(args[args.length - 1].trim());

            String name = args[1];
            for (int i = 2; i < args.length - 2; i++) {
                name += " " + args[i];
            }
            if (name.length() > 30) {
                name = name.substring(0, 30);
            }
            out.write(String.format("%n%-8d%-30s%-8.2f%-4d", searchMaxId(fileName), name,
                    price, quantity).getBytes());

            reader.close();
            out.close();
        }
    }

    private static int searchMaxId(String fileName) throws IOException {
        FileReader in = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(in);
        int maxId = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            int id = Integer.parseInt(line.substring(0, 8).trim());
            if (maxId < id) {
                maxId = id;
            }
        }
        reader.close();
        in.close();
        return ++maxId;
    }
}
