package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;
    private List<Horse> horses;

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList());
        Horse horseOne = new Horse("Burka", 3, 0);
        Horse horseTwo = new Horse("Sivka", 3, 0);
        Horse horseThree = new Horse("Gorbunok", 3, 0);

        game.getHorses().add(horseOne);
        game.getHorses().add(horseTwo);
        game.getHorses().add(horseThree);

        game.run();
        game.printWinner();
    }

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }
}
