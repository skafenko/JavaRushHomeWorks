package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum ;
        //напишите тут ваш код
        int N =Integer.parseInt(reader.readLine());
        if(N>0) {
            int nn = Integer.parseInt(reader.readLine());
            maximum=nn;
            for (  int n = 1;n < N;n++) {
                int n1 = Integer.parseInt(reader.readLine());
                if(n1>maximum)
                {
                    maximum=n1;
                }
            }
            System.out.println(maximum);
        }
    }
}
