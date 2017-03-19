package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Mykhailo on 24.01.2016.
 */
public class RussianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 40;
    }
    public String getDescription()
    {
        return String.format(super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
