package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {


    }

    public static boolean isDateOdd(String date)
    {
        Date firstDate=new Date(date);
        firstDate.setHours(0);
        firstDate.setMinutes(0);
        firstDate.setSeconds(0);
        firstDate.setDate(0);
        firstDate.setMonth(0);
        Date date1=new Date(date);
        long countDay=date1.getTime()-firstDate.getTime();
        long msDay=24*60*60*1000;
        int dayCount=(int)(countDay/msDay);
        if (dayCount % 2 == 0)
            return false;
        else
            return true;
    }
}
