package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, PieceOfData> piecesOfData = new TreeMap<>();
        FileInputStream in;
        FileOutputStream out;

        String nameIn;
        String nameOut = null;
        try {
            while (!(nameIn = reader.readLine()).equals("end")) {
                if (nameOut == null) {
                    nameOut = nameIn.substring(0, nameIn.indexOf(".part"));
                }
                int num = Integer.parseInt(nameIn.substring(nameIn.indexOf(".part") + 5));
                in = new FileInputStream(nameIn);
                PieceOfData piece = new PieceOfData(in.available());
                in.read(piece.getBuffer());
                piecesOfData.put(num, piece);
                in.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        try {
            out = new FileOutputStream(nameOut, true);
            for (Map.Entry pair : piecesOfData.entrySet()){
                PieceOfData piece = (PieceOfData) pair.getValue();
                out.write(piece.getBuffer());
            }
            out.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
