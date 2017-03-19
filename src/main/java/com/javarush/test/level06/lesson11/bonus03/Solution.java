package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
      int n1=Integer.parseInt(reader.readLine());
      int n2=Integer.parseInt(reader.readLine());
        int first=n1<n2?n1:n2;
        int second=n1>n2?n1:n2;
        int n3=Integer.parseInt(reader.readLine());
        int third=0;
        if (n3>first&&n3>second)
             third=n3;
        else if(n3>first&&n3<second){
            third=second;
            second=n3;
        }
        else {
            third=second;
            second=first;
            first=n3;
        }
        int n4=Integer.parseInt(reader.readLine());
        int fourth=0;
        if(n4<first){
            fourth=third;
            third=second;
            second=first;
            first=n4;
        }
        else if(n4>first&&n4<second){
        fourth=third;
        third=second;
        second=n4;
    }
        else if(n4>second&&n4<third){
            fourth=third;
            third=n4;
        }
        else
        fourth=n4;
     int n5=Integer.parseInt(reader.readLine());
             int fifth=0;
        if (n5<first){
            fifth=fourth;
            fourth=third;
            third=second;
            second=first;
            first=n5;
        }
        else if(n5>first&&n5<second){
            fifth=fourth;
            fourth=third;
            third=second;
            second=n5;
        }
        else if(n5>second&&n5<third){
            fifth=fourth;
            fourth=third;
            third=n5;
        }
        else if(n5>third&&n5<fourth){
            fifth=fourth;
            fourth=n5;
        }
        else
        fifth=n5;



        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
    }
}
