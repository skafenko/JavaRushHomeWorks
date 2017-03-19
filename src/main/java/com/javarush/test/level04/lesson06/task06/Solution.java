package com.javarush.test.level04.lesson06.task06;

/* Создать программу, которая будет сообщать, является ли целое число, введённое пользователем, чётным или нечётным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
*/

import java.util.Scanner;

 class Main
{
    public static void main(String[] args)
    {
Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            int n=sc.nextInt();
            if(n%2==0)
            System.out.print("парне число");
            else
                System.out.print(" не парне число");
        }
        else
            System.out.print("Вы ввели не целое число");
    }

}
