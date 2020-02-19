package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
//    E:/Java/Files/FirstFile.txt

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder data = new StringBuilder();

        String str;
        while ((str = in.readLine()) != null) {
            data.append(str + " ");
        }

        writeDownPair(data.toString());

        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    private static void writeDownPair(String data) throws IOException {

        String[] separatedString = data.split(" ");

        for (int i = 0; i < separatedString.length - 1; i++) {
            for (int j = i + 1; j < separatedString.length; j++) {
                if (new StringBuilder(separatedString[j]).reverse().toString().equals(separatedString[i])) {
                    Pair pair = new Pair(separatedString[i], separatedString[j]);
                    if (!result.contains(pair)) {
                        result.add(pair);
                    }
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
