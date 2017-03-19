package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        int suma=0;
        for (;true;)
        {
            String n=b.readLine();
            if(n.equals("сумма")) {
                System.out.println(suma);
                break;
            }
            int aN=Integer.parseInt(n);
            suma = suma+aN;
        }
    }
}
