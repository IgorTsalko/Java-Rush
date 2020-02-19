package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream firstOutputStream = new FileOutputStream(reader.readLine());
        FileOutputStream secondOutputStream = new FileOutputStream(reader.readLine());

        byte[] partOne = new byte[(int) Math.ceil(inputStream.available() / 2.0)];
        byte[] partTwo = new byte[inputStream.available() / 2];

        while (inputStream.available() > 0) {
            inputStream.read(partOne);
            firstOutputStream.write(partOne);
            inputStream.read(partTwo);
            secondOutputStream.write(partTwo);
        }

        inputStream.close();
        firstOutputStream.close();
        secondOutputStream.close();
        reader.close();

//        E:/Java/Files2/firstFile.txt
//        E:/Java/Files2/secondFile.txt
//        E:/Java/Files2/thirdFile.txt
    }
}
