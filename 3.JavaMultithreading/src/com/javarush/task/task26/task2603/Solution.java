package com.javarush.task.task26.task2603;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
//        Set<Person> persons = new TreeSet<>(new CustomizedComparator<>(new ComparatorName(), new ComparatorAge(), new ComparatorHeight()));
//        persons.add(new Person("Alex", 29, 68));
//        persons.add(new Person("Alex", 29, 79));
//        persons.add(new Person("Alex", 29, 85));
//        persons.add(new Person("Alex", 29, 73));
//        persons.add(new Person("Alex", 29, 95));
//
//        for (Person person : persons) {
//            System.out.println(person);
//        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = comparators[0].compare(o1, o2);
            if (result == 0) {
                for (int i = 1; i < comparators.length; i++) {
                    result = comparators[i].compare(o1, o2);
                    if (result != 0) {
                        break;
                    }
                }
            }
            return result;
        }
    }
}

//class Person {
//    private String name;
//    private int age;
//    private int height;
//
//    public Person(String name, int age, int height) {
//        this.name = name;
//        this.age = age;
//        this.height = height;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", height=" + height +
//                '}';
//    }
//}
//
//class ComparatorName implements Comparator<Person> {
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}
//
//class ComparatorAge implements Comparator<Person> {
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getAge() - o2.getAge();
//    }
//}
//
//class ComparatorHeight implements Comparator<Person> {
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o2.getHeight() - o1.getHeight();
//    }
//}
