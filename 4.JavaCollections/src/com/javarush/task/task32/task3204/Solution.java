package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
//        ByteArrayOutputStream password = getPassword();
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream arrayPassword;
        String[] chars = {"0123456789", "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
        while (true) {
            arrayPassword = new ByteArrayOutputStream();
            for (int i = 0; i < 8; i++) {
                String letters = chars[(int) (chars.length * Math.random())];
                byte randomChar = (byte) letters.charAt((int) (letters.length() * Math.random()));
                arrayPassword.write(randomChar);
            }


            String generatedPassword = arrayPassword.toString();
            boolean hasNum = false;
            boolean hasSmallChar = false;
            boolean hasLargeChar = false;
            for (int i = 0; i < chars[0].length(); i++) {
                if (generatedPassword.contains(String.valueOf(chars[0].charAt(i)))) {
                    hasNum = true;
                    break;
                }
            }

            for (int i = 0; i < chars[1].length(); i++) {
                if (generatedPassword.contains(String.valueOf(chars[1].charAt(i)))) {
                    hasSmallChar = true;
                    break;
                }
            }

            for (int i = 0; i < chars[2].length(); i++) {
                if (generatedPassword.contains(String.valueOf(chars[2].charAt(i)))) {
                    hasLargeChar = true;
                    break;
                }
            }

            if (hasNum && hasSmallChar && hasLargeChar) {
                break;
            }
        }

        return arrayPassword;
    }
}