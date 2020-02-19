package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(fullName);
//            out.writeObject(greeting);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            fullName = (String) in.readObject();
//            greeting = (String) in.readObject();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", greeting='" + greeting + '\'' +
                    ", country='" + country + '\'' +
                    ", sex=" + sex +
                    ", outputStream=" + outputStream +
                    ", logger=" + logger +
                    '}';
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        Person person = new Person("Igor", "Tsalko", "Belarus", Sex.MALE);
        System.out.println(person);
        Person copyPerson = null;

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("File.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("File.txt"));
            out.writeObject(person);
            copyPerson = (Person) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(copyPerson);
    }
}
