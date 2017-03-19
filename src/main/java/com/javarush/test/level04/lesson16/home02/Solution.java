package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
       Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        if(n1>n2&&n1<n3||n1>n3&&n1<n2)
            System.out.print(n1);
         if (n2>n1&&n2<n3||n2>n3&&n2<n1)
            System.out.print(n2);
         if (n3>n1&&n3<n2||n3>n2&&n3<n1)
            System.out.print(n3);
    }
}
