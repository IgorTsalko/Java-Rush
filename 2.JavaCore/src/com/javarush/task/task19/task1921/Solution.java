package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() < 2) {
                    continue;
                }
                String name = line.replaceAll("\\d", "").trim();
                Date date = format.parse(line.replace(name, "").trim());

                PEOPLE.add(new Person(name, date));
            }

//            for (Person person : PEOPLE) {
//                System.out.printf("%s %s\n", person.getName(), person.getBirthDate());
//            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
