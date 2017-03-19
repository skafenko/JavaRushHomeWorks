package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Mykhailo on 27.02.2016.
 */
public class Plane implements Flyable
{
    private int amountOfPeople;

    Plane(int amountOfPeople)
    {
        this.amountOfPeople = amountOfPeople;
    }

    @Override
    public void fly() {

    }
}
