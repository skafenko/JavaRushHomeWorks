package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        Scanner scanner = new Scanner(System.in);
        String uri = scanner.nextLine();
        ArrayList<String> parameters = new ArrayList<>();
        String rigthString = uri.substring(uri.indexOf("?") + 1);
        String[] parameters1 = rigthString.split("\\&+");
        for (int i = 0; i < parameters1.length; i++)
        {
            int indexLast =  parameters1[i].indexOf("=");
            if (indexLast == -1)
            {
                indexLast = parameters1[i].length();
            }
            String param = parameters1[i].substring(0, indexLast);
            System.out.print(param + " ");
            if (param.equals("obj") && parameters1[i].indexOf("=") != -1)
                parameters.add(parameters1[i].substring(indexLast + 1));

        }
        System.out.println();
        for (String item : parameters)
        {
            if (item.matches("\\-?\\d*\\.?\\d*"))
            {
                double d = Double.parseDouble(item);
                alert(d);
            }
            else
                alert(item);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
