package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length != 0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        executeC(args);
                    }
                break;
                case "-u":
                synchronized (allPeople) {
                     executeU(args);
                }
                break;
                case "-d":
                    synchronized (allPeople) {
                        executeD(args);
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        executeI(args);
                    }
                    break;
            }
        }
    }

    public static void executeC(String[] parameters) throws ParseException {
        Date date;

        for (int i = 0; i < parameters.length - 3; i += 3) {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(parameters[i + 3]);

            if (parameters[i + 2].toLowerCase().equals("м")) allPeople.add(Person.createMale(parameters[i + 1], date));
            if (parameters[i + 2].toLowerCase().equals("ж")) allPeople.add(Person.createFemale(parameters[i + 1], date));
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void executeU(String[] parameters) throws ParseException {
        Sex sex;
        Date date;
        Person person;

        for (int i = 0; i < parameters.length - 4; i += 4) {
            person = allPeople.get(Integer.parseInt(parameters[i + 1]));
            sex = parameters[i + 3].equals("м")? Sex.MALE : Sex.FEMALE;
            date = new SimpleDateFormat("dd/MM/yyyy").parse(parameters[i + 4]);

            person.setName(parameters[i + 2]);
            person.setBirthDate(date);
            person.setSex(sex);
        }
    }

    public static void executeD(String[] parameters) {
        Person person;
        for (int i = 1; i < parameters.length; i++) {
            person = allPeople.get(Integer.parseInt(parameters[i]));

            person.setName(null);
            person.setBirthDate(null);
            person.setSex(null);
        }
    }

    public static void executeI(String[] parameters) {
        Person person;
        String sex;
        for (int i = 1; i < parameters.length; i++) {
            person = allPeople.get(Integer.parseInt(parameters[i]));
            sex = person.getSex().equals(Sex.MALE)? "м" : "ж";

            System.out.println(person.getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
        }
    }

//    public static void showPerson() {
//        for (Person p : allPeople) {
//            System.out.println("Имя: " + p.getName() + ", Дата рождения: " + p.getBirthDate() + ", Пол: " + p.getSex());
//        }
//    }
}
