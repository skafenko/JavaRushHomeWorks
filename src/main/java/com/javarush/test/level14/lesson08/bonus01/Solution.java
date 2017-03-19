package com.javarush.test.level14.lesson08.bonus01;

import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws IllegalFormatException {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int d = 1 / 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            List<Integer> list = new ArrayList<>();
            list.get(4);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            List<Integer> list = new ArrayList<>();
            list.get(-2);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            List<Integer> list = null;
            list.remove(3);

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int i = Integer.parseInt("dkf");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new InputMismatchException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ArrayStoreException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalFormatCodePointException(4);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
