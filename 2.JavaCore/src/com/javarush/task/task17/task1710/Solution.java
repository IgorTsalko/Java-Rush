package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args[0].equals("-c")) {
            Date birthDay = Solution.parseStringToDate(args[3]);
            if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], birthDay));
            if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], birthDay));
            System.out.println(allPeople.size()-1);
        }
        if (args[0].equals("-u")) {
            Date birthDay = Solution.parseStringToDate(args[4]);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(birthDay);
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            Sex sex = args[3].equals("м")? Sex.MALE : Sex.FEMALE;
            allPeople.get(Integer.parseInt(args[1])).setSex(sex);
        }
        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
        }
        if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.print(person.getName() + " ");
            if (person.getSex().equals(Sex.MALE)) System.out.print("м ");
            else System.out.print("ж ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(dateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
        }
    }

    public static Date parseStringToDate(String stringDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date parseDate = null;

        try {
            parseDate = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parseDate;
    }
}
