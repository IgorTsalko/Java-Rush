package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try {
            File file = new File("E:/Java/Files/firstFile.txt");
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream(file);
            Solution savedObject = new Solution(5);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(savedObject);
            Solution otherObject = new Solution(1);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            Solution loadedObject = (Solution) in.readObject();
            System.out.println(savedObject.string);
            System.out.println(loadedObject.string);
            System.out.println(savedObject.string.equals(loadedObject.string));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
