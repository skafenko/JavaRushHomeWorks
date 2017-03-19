package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Mykhailo on 12.06.2016.
 */
public class Hippodrome {

    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horse1 = new Horse("Speeder", 3, 0);
        Horse horse2 = new Horse("First", 3, 0);
        Horse horse3 = new Horse("Champion", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

        game.printWinner();
    }
    public Horse getWinner(){
        Horse winner = null;
        double startDistance = 0;
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() > startDistance)
            {
                startDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void print(){
        for (Horse horse : getHorses())
        {
            horse.print();
            System.out.println();
        }
    }

    public void move() {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }
}
