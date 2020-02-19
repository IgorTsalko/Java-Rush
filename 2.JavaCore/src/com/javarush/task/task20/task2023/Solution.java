package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/
public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() { //4
            System.out.println("A class, method2"); //5
            method1();
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2(); //3
            System.out.println("B class, method1"); //6
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2"); //1
//            super.method1(); //2
        }
    }
}
