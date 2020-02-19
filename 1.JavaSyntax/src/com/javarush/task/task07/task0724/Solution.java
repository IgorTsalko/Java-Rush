package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human firstGrandfather = new Human("Виктор",true,68);
        Human secondGrandfather = new Human("Дмитрий",true,73);
        Human firstGrandmother = new Human("Мария",false,64);
        Human secondGrandmother = new Human("Афдосья",false,72);
        Human father = new Human("Миша",true,43, firstGrandfather, firstGrandmother);
        Human mother = new Human("Катя",false,44, secondGrandfather, secondGrandmother);
        Human firstChild = new Human("Женя",true,16, father, mother);
        Human secondChild = new Human("Паша",true,13, father, mother);
        Human thirdChild = new Human("Вика", false, 8, father, mother);

        System.out.println(firstGrandfather);
        System.out.println(secondGrandfather);
        System.out.println(firstGrandmother);
        System.out.println(secondGrandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(firstChild);
        System.out.println(secondChild);
        System.out.println(thirdChild);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}