package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int t = print(10);
        Integer e = print(10);
    }

    //Напишите тут ваши методы
    public static int print(int i)
    {
        return i;

    }

    public static Integer print(Integer k)
    {
        return k;
    }
}
