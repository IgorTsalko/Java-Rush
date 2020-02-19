package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            readAndWrite(nameReader.readLine(), allLines);
            readAndWrite(nameReader.readLine(), forRemoveLines);
            nameReader.close();
        } catch (IOException e) {
            System.out.println("Неверное имя (путь) файла");
        }

        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch(CorruptedDataException e) {
            System.out.println("Исключение, поврежденные данные");
        }

        for (String str : allLines) {
            System.out.println(str);
        }
    }

    public void joinData() throws CorruptedDataException {
        int count = 0;
        for (int i = 0; i < forRemoveLines.size(); i++) {
            for (int j = 0; j < allLines.size(); j++) {
                if (forRemoveLines.get(i).equals(allLines.get(j))) {
                    count++;
                }
            }
        }
        if (count == forRemoveLines.size()) removeLines();
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void readAndWrite(String fileName, List<String> list) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        while((line = fileReader.readLine()) != null) {
            list.add(line);
        }

        fileReader.close();
    }

    public static void removeLines() {
        for (int i = 0; i < forRemoveLines.size(); i++) {
            allLines.remove(forRemoveLines.get(i));
        }
    }
}
