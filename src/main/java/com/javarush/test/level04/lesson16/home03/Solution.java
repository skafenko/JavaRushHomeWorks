package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        int z=0;
        while(true) {
        String n=b.readLine();//напишите тут ваш код
        int n1 = Integer.parseInt(n);
            z=z+n1;
            if ( n1 == -1) {
                System.out.println(z);
                break;
            }
        }
    }
}
