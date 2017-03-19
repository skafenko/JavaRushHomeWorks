package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s1=reader.readLine();
        String s2=reader.readLine();
        String s3=reader.readLine();
        String s4=reader.readLine();
        int a1 = Integer.parseInt(s1);
        int a2 = Integer.parseInt(s2);
        int a3 = Integer.parseInt(s3);
        int a4 = Integer.parseInt(s4);
        if(a1>a2&&a1>a3&&a1>a4)
            System.out.println(a1);
        else if (a2 > a3 && a2 > a1 && a2 > a4)
                System.out.println(a2);
            else if (a3 > a1 && a3 > a2 && a3 > a4)
                    System.out.println(a3);
                else
                    System.out.println(a4);

        }

    }

