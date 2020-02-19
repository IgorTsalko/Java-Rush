package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;


/*
Составить цепочку слов
E:/Java/Files/FirstFile.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        StringBuilder result = getLine(fileReader.readLine().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder();
        }

        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
            recursion(list, tempList, words);
            list.remove(words[i]);
        }

        for (int i = 0; i < tempList.size(); i++) {
            stringBuilder.append(tempList.get(i));
            if (i != tempList.size() - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder;
    }

    public static void recursion(ArrayList<String> list, ArrayList<String> tempList, String... words) {
        for (int i = 0; i < words.length; i++) {
            String last = list.get(list.size() - 1);
            if (!list.contains(words[i]) && Character.toLowerCase(last.charAt(last.length() - 1)) == Character.toLowerCase(words[i].charAt(0))) {
                list.add(words[i]);
                recursion(list, tempList, words);
                list.remove(words[i]);
            }
        }

        if (tempList.size() < list.size()) {
            tempList.clear();
            for (String string : list) {
                tempList.add(string);
            }
        }
    }
}
