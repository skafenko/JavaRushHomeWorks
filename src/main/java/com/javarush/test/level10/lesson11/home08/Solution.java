package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        list1.add("This is list1");
        list1.add("Next list2");
        list2.add("This is list2");
        list2.add("Next list3");
        list3.add("This is list3");
        list3.add("Finish");

        list[0] = list1;
        list[1] = list2;
        list[2] = list3;
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}