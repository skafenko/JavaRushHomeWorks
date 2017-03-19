package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //напишите тут ваш код
        HashMap<String,String> createPeopleList=new HashMap<String,String>();
        createPeopleList.put("Put","Mary");
        createPeopleList.put("Freeman","Klan");
        createPeopleList.put("List","Dan");
        createPeopleList.put("Put","Man");
        createPeopleList.put("Gonby","Mary");
        createPeopleList.put("Luky","Evgen");
        createPeopleList.put("Put","Dima");
        createPeopleList.put("Dean","Mary");
        createPeopleList.put("Stefan","Yaruk");
        createPeopleList.put("Saroman","Sasha");

        return createPeopleList;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
