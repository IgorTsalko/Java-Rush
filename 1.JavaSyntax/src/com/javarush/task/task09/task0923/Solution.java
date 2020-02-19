package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] chars = str.toCharArray();
        ArrayList<Character> characterVowels = new ArrayList<>();
        ArrayList<Character> characterConsonant = new ArrayList<>();

        for (Character c : chars) {
            if (isVowel(c)) {
                characterVowels.add(c);
                characterVowels.add(' ');
            } else if (Character.isWhitespace(c)){

            } else {
                characterConsonant.add(c);
                characterConsonant.add(' ');
            }
        }

        for (Character c : characterVowels) {
            System.out.print(c);
        }

        System.out.println("");

        for (Character c : characterConsonant) {
            System.out.print(c);
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}