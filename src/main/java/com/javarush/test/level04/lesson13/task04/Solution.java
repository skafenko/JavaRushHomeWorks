package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 11; i++) {
            for (int s=0; s < 10; s++) {
                if(i==0||s==0)
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
