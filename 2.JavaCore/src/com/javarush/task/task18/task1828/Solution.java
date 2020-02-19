package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
//        E:/Java/Files/firstFile.txt
//        -u 198479 GPS Navigator Geofox mid 702 v2 155.00 28
            if (args.length > 0) {
                if (args[0].equals("-u")) {
                    byte[] data = updateFile(fileName, args);
                    FileOutputStream out = new FileOutputStream(fileName);
                    out.write(data);
                    out.close();
                } else if (args[0].equals("-d")) {
                    byte[] data = deleteProduct(fileName, args);
                    FileOutputStream out = new FileOutputStream(fileName);
                    out.write(data);
                    out.close();
                } else {
                    System.out.println("Неверный параметр!");
                }
            }
            reader.close();
        }

        private static byte[] updateFile(String fileName, String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String data = "";
            float price = Float.parseFloat(args[args.length - 2].trim());
            String name = args[2];
            for (int i = 3; i < args.length - 2; i++) {
                name += " " + args[i];
            }
            if (name.length() > 30) {
                name = name.substring(0, 30);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.substring(0, 8).trim().equals(args[1])) {
                    data += String.format("%n%-8s%-30s%-8.2f%-4s", args[1], name, price, args[args.length - 1]);
                } else {
                    if (data.length() > 0) {
                        data += "\n";
                    }
                    data += (line);
                }
            }
            reader.close();
            return data.getBytes();
        }

        private static byte[] deleteProduct(String fileName, String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String data = "";

            String line;
            while ((line = reader.readLine()) != null) {
                if (!(line.substring(0, 8).trim().equals(args[1]))) {
                    if (data.length() > 0) {
                        data += ("\n");
                    }
                    data += line;
                }
            }

            reader.close();
            return data.getBytes();
        }
}
