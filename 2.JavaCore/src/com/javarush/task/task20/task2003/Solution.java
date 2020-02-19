package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

//    E:/Java/Files/property.properties.txt
    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            load(new FileInputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.putAll(properties);
        pr.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.load(inputStream);
        for (Map.Entry property : pr.entrySet()) {
            properties.put((String) property.getKey(), (String) property.getValue());
        }
    }

    public static void main(String[] args) {
        FileInputStream in;
        Properties properties;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
