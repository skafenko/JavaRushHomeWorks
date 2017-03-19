package com.javarush.test.level04.lesson13.task02;

import java.io.*;
import java.util.Scanner;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc =new Scanner(System.in);
        for( int m=sc.nextInt();m>0;m--) {
            int n = sc.nextInt();
            for (int a = 0; a <n; a++) {
                System.out.print("8");
            }
            System.out.println();
        }

    }
}
