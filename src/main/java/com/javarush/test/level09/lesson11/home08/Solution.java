package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
      ArrayList<int[]> list=new ArrayList<int[]>();
        int[] a5={1,2,3,4,5};
        int[] a2={1,2};
        int[] a4={1,2,3,4};
        int[] a7={1,2,3,4,5,6,7};
        int[] a0={};
        list.add(a5);
        list.add(a2);
        list.add(a4);
        list.add(a7);
        list.add(a0);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
