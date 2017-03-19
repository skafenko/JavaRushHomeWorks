package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static int min(int s, int v)
    {
        return s > v ? v : s;
    }

    public static long min(long l, long l2)
    {
        return l < l2 ? l : l2;
    }

    public static double min(double d, double b)
    {
        return d < b ? d : b;
    }
}
