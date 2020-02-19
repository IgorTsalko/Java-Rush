package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String str = null;
            System.out.println(str.toString());
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] ints = new int[2];
            System.out.println(ints[3]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader( new InputStreamReader(new FileInputStream("E:/123.txt")));
        }  catch (Exception e) {
            exceptions.add(e);
        }

        SimpleDateFormat simpleDateFormat;
        try {
            simpleDateFormat = new SimpleDateFormat("PPP VVV");
            simpleDateFormat.format(new Date());
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Double d = new Double("123-5");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Ex(1);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Ex(2);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Ex(3);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Ex(4);
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    public static void Ex(int num) throws MyOneException, MyTwoException, MyThreeException, MyFourException {
        if (num == 1)
            throw new MyOneException();
        else if (num == 2)
            throw new MyTwoException();
        else if (num == 3)
            throw new MyThreeException();
        else if (num == 4)
            throw new MyFourException();
    }
}
