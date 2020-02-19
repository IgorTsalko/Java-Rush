package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                //0  //1  //2  //3  //4  //5
                {'f', 'd', 'e', 't', 'a', 'k'},//0
                {'o', 's', 'a', 'm', 'e', 'o'},//1
                {'c', 'n', 'o', 'r', 'o', 'v'},//2
                {'u', 'r', 'p', 'r', 'r', 'h'},//3
                {'s', 'o', 'e', 'n', 'o', 'j'} //4
        };
        List<Word> result = detectAllWords(crossword, "sucof", "dsn", "eta", "jon", "roma", "darr", "kerpo", "home", "same", "focus");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        for (String str : words) {
            result.addAll(detectWord(crossword, str));
        }
        return result;
    }

    private static List<Word> detectWord(int[][] crossword, String w) {
        List<Word> buff = new ArrayList<>();
        char letter = w.charAt(0);
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == (int) letter ) {
                    List<Word> result = checkWay(i, j, crossword, w);

                    if (result.size() > 0) {
                        buff.addAll(result);
                    }
                }
            }
        }
        return buff;
    }

    private static List<Word> checkWay(int i, int j, int[][] crossword, String w) {
        List<Word> buff = new ArrayList<>();

        if (i != 0 && crossword[i - 1][j] == (int) w.charAt(1)) {
            int eX = j;
            int eY = i - w.length() + 1;

            if (eX >= 0 && i >= 0 && eX < crossword[0].length && i < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixUp(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (j != crossword[0].length - 1 && crossword[i][j + 1] == (int) w.charAt(1)) {
            int eX = j + w.length() - 1;
            int eY = i;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixRight(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (i != crossword.length - 1 && crossword[i + 1][j] == (int) w.charAt(1)) {
            int eX = j;
            int eY = i + w.length() - 1;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixDown(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (j != 0 && crossword[i][j - 1] == (int) w.charAt(1)) {
            int eX = j - w.length() + 1;
            int eY = i;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixLeft(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (i != 0 && j != crossword[0].length - 1 && crossword[i - 1][j + 1] == (int) w.charAt(1)) {
            int eX = j + w.length() - 1;
            int eY = i - w.length() + 1;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixUpRight(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (i != crossword.length - 1 && j != crossword[0].length - 1
                && crossword[i + 1][j + 1] == (int) w.charAt(1)) {
            int eX = j + w.length() - 1;
            int eY = i + w.length() - 1;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixDownRight(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (i != crossword.length - 1 && j != 0 && crossword[i + 1][j - 1] == (int) w.charAt(1)) {
            int eX = j - w.length() + 1;
            int eY = i + w.length() - 1;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixDownLeft(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        if (i != 0 && j != 0 && crossword[i - 1][j - 1] == (int) w.charAt(1)) {
            int eX = j - w.length() + 1;
            int eY = i - w.length() + 1;

            if (eX >= 0 && eY >= 0 && eX < crossword[0].length && eY < crossword.length) {
                Word word = new Word(w);
                word.setStartPoint(j, i);
                word.setEndPoint(eX, eY);

                if (checkWordInMatrixUpLeft(word.startX, word.startY, w, crossword)){
                    buff.add(word);
                }
            }
        }
        return buff;
    }

    private static boolean checkWordInMatrixUp(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY - i][sX]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixRight(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY][sX + i]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixDown(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY + i][sX]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixLeft(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY][sX - i]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixUpRight(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY - i][sX + i]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixDownRight(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY + i][sX + i]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixDownLeft(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY + i][sX - i]) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWordInMatrixUpLeft(int sX, int sY, String word, int[][] crossword) {
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != crossword[sY - i][sX - i]) {
                result = false;
            }
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int x, int y) {
            startX = x;
            startY = y;
        }

        public void setEndPoint(int x, int y) {
            endX = x;
            endY = y;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
