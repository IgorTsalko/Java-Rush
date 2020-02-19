package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat firstCat = new Cat("Васька", 5, 6, 12);
        Cat secondCat = new Cat("Пыска", 2, 3, 6);
        Cat thirdCat = new Cat("Мармышка", 4, 4, 7);
        System.out.println(firstCat.fight(secondCat));
        System.out.println(firstCat.fight(thirdCat));
        System.out.println(thirdCat.fight(secondCat));
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
