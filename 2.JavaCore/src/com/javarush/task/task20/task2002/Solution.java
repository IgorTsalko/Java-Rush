package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User firstUser = new User();
//            User secondUser = new User();

            firstUser.setBirthDate(new Date(System.currentTimeMillis()));
            firstUser.setCountry(User.Country.RUSSIA);
            firstUser.setFirstName("Oleg");
            firstUser.setLastName("Olegov");
            firstUser.setMale(true);

//            secondUser.setBirthDate(new Date(System.currentTimeMillis() - 6912000000L));
//            secondUser.setCountry(User.Country.UKRAINE);
//            secondUser.setFirstName("Natasha");
//            secondUser.setLastName("Zaribina");
//            secondUser.setMale(false);

            javaRush.users.add(firstUser);
//            javaRush.users.add(secondUser);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут,
            //что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            System.out.println(javaRush.toString());
            System.out.println(loadedObject.toString());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            for (User user : users) {
                outputStream.write((user.getFirstName() + "\n").getBytes());
                outputStream.write((user.getLastName() + "\n").getBytes());
                outputStream.write((user.isMale() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getTime() + "\n").getBytes());
                outputStream.write((user.getCountry() + "\n").getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            while (in.ready()) {
                User user = new User();

                user.setFirstName(in.readLine());
                user.setLastName(in.readLine());

                String isMale = in.readLine();
                if (isMale.equals("true")) {
                    user.setMale(true);
                } else
                    user.setMale(false);

                user.setBirthDate(new Date(Long.parseLong(in.readLine())));

                String country = in.readLine();
                if (country.equals("UKRAINE")) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (country.equals("RUSSIA")) {
                    user.setCountry(User.Country.RUSSIA);
                } else if (country.equals("OTHER")) {
                    user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
