package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Mykhailo on 07.02.2016.
 */
public class Singleton
{
    final static Singleton singleton = new Singleton();
    public static Singleton getInstance()
    {
        return singleton;
    }
    private Singleton()
    {

    }
}
