package com.javarush.task.task18.task1825;

public class PieceOfData {
    private byte[] buffer;

    public PieceOfData(int size) {
        buffer = new byte[size];
    }

    public byte[] getBuffer() {
        return buffer;
    }
}
