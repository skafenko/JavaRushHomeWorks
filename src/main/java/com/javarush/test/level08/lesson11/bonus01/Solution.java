package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String month=sc.nextLine();
        ArrayList<String> callendar= new ArrayList<String>();
        callendar.add("January");
        callendar.add("February");
        callendar.add("March");
        callendar.add("April");
        callendar.add("May");
        callendar.add("June");
        callendar.add("July");
        callendar.add("Agust");
        callendar.add("September");
        callendar.add("October");
        callendar.add("November");
        callendar.add("December");
       for(int i=0;i<callendar.size();i++)
       {
           if(month.equals(callendar.get(i)))
               System.out.println(month+" is "+(i+1)+" month");
       }
    }

}
