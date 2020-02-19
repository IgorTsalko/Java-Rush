package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human firstChildren = new Human();
        firstChildren.name = "FirstChildren";
        firstChildren.age = 40;
        firstChildren.sex = true;

        Human secondChildren = new Human();
        secondChildren.name = "SecondChildren";
        secondChildren.age = 35;
        secondChildren.sex = false;

        Human thirdChildren = new Human();
        thirdChildren.name = "ThirdChildren";
        thirdChildren.age = 30;
        thirdChildren.sex = false;

        Human father = new Human();
        father.name = "Father";
        father.age = 65;
        father.sex = true;
        father.children.add(firstChildren);
        father.children.add(secondChildren);
        father.children.add(thirdChildren);

        Human mother = new Human();
        mother.name = "Mather";
        mother.age = 60;
        mother.sex = false;
        mother.children.add(firstChildren);
        mother.children.add(secondChildren);
        mother.children.add(thirdChildren);

        Human firstGrandfather = new Human();
        firstGrandfather.name ="FirstGrandfather";
        firstGrandfather.age = 95;
        firstGrandfather.sex = true;
        firstGrandfather.children.add(father);

        Human firstGrandmather = new Human();
        firstGrandmather.name = "FirstGrandmather";
        firstGrandmather.age = 90;
        firstGrandmather.sex = false;
        firstGrandmather.children.add(father);

        Human secondGrandfather = new Human();
        secondGrandfather.name ="SecondGrandfather";
        secondGrandfather.age = 85;
        secondGrandfather.sex = true;
        secondGrandfather.children.add(mother);

        Human secondGrandmather = new Human();
        secondGrandmather.name = "SecondGrandmather";
        secondGrandmather.age = 80;
        secondGrandmather.sex = false;
        secondGrandmather.children.add(mother);

        System.out.println(firstChildren);
        System.out.println(secondChildren);
        System.out.println(thirdChildren);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(firstGrandfather);
        System.out.println(firstGrandmather);
        System.out.println(secondGrandfather);
        System.out.println(secondGrandmather);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
