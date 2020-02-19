package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top;
    int left;
    int width;
    int height;

    public void initialize(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left, int top) {
        this.left = left;
        this.top = top;
        this.width = left;
        this.height = top;
    }

    public void initialize(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }

    public void initialize(Rectangle rect) {
        this.left = rect.left;
        this.top = rect.top;
        this.width = rect.width;
        this.height = rect.height;
    }

    public static void main(String[] args) {

    }
}
