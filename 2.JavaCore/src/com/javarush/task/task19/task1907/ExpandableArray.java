package com.javarush.task.task19.task1907;

public class ExpandableArray {
    private byte[] array = new byte[10];
    private int count = 0;

    public void putValue(byte value) {
        if (count > array.length - 1) {
            byte[] newArray = new byte[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[count++] = value;
    }

    public byte[] getArray() {
        return array;
    }
}
