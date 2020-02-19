package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int rangeCatOne = 0;
        int rangeCatTwo = 0;
        if (this.age > anotherCat.age)
            rangeCatOne++;
        else if (this.age == anotherCat.age) {
            rangeCatOne++;
            rangeCatTwo++;
        } else
            rangeCatTwo++;

        if (this.weight > anotherCat.weight)
            rangeCatOne++;
        else if (this.weight == anotherCat.weight) {
            rangeCatOne++;
            rangeCatTwo++;
        } else
            rangeCatTwo++;

        if (this.strength > anotherCat.strength)
            rangeCatOne++;
        else if (this.strength == anotherCat.strength) {
            rangeCatOne++;
            rangeCatTwo++;
        } else
            rangeCatTwo++;

        if (rangeCatOne == rangeCatTwo)
            return false;
        else if (rangeCatOne > rangeCatTwo)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Cat catOne = new Cat();
        catOne.age = 5;
        catOne.strength = 10;
        catOne.weight = 6;

        Cat catTwo = new Cat();
        catTwo.age = 5;
        catTwo.strength = 5;
        catTwo.weight = 6;

        boolean i = catOne.fight(catTwo);
        System.out.println(i);
    }
}
