package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> set =new HashSet<String>();
       set.add("Лен");
       set.add("Леон");
       set.add("Лай");
       set.add("Лак");
       set.add("Лень");
       set.add("Лахмиття");
       set.add("Лошара");
       set.add("Лекцыя");
       set.add("Лунатик");
       set.add("Луна");
       set.add("Лагуна");
       set.add("Лошадь");
       set.add("Лабораторна");
       set.add("Лина");
       set.add("Лариса");
       set.add("Люксембург");
       set.add("Лох");
       set.add("Лол");
       set.add("Лизати");
       set.add("Лежати");
        return set;
    }
}
