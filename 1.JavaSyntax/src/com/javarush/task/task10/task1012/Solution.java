package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += reader.readLine();
        }

        char[] chars = str.toCharArray();

        // Мой код
        for (Character c : alphabet) {
            System.out.print(c);
            int count = 0;

            for (int i = 0; i < chars.length; i++) {
                if (c == chars[i])
                    count++;
            }

            System.out.println(" " + count);
        }
    }
}
