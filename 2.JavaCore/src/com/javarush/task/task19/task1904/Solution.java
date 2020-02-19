package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner sc) {
            fileScanner = sc;
        }

        @Override
        public Person read() throws IOException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            String data = fileScanner.nextLine();
            String[] words = data.split("\\s");

            String firstName = words[1];
            String middleName = words[2];
            String lastName = words[0];
            String dataString = data.substring(firstName.length() + middleName.length() + lastName.length() + 3);
            Date birthDate = null;
            try {
                birthDate = dateFormat.parse(dataString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
