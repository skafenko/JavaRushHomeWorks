package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Mykhailo on 24.01.2016.
 */
public class MoldovanHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 45;
    }
    public String getDescription()
    {
        return String.format(super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
