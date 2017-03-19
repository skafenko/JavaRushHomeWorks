package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Mykhailo on 24.02.2016.
 */
public class USD extends Money
{
    USD (double amount)
    {
        super(amount);
    }
    public String getCurrencyName() { return  "USD";}
}
