package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Mykhailo on 28.02.2016.
 */
public class LatteMaker extends DrinkMaker
{
    @Override
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }

    @Override
    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }
}
