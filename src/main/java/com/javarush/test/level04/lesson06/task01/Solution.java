package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s1=reader.readLine();
        String s2=reader.readLine();
       int a1 = Integer.parseInt(s1);
       int a2 = Integer.parseInt(s2);
        if(a1<a2)
         System.out.println(a1);
        else
            System.out.println(a2);

    }
}