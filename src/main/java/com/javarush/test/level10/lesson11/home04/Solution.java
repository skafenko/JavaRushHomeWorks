package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.LinkedList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        char[] list=s.toCharArray();
        LinkedList<Character> l=new LinkedList<Character>();
        for(int n=0;n<list.length;n++)
        {
            l.add(list[n]);
        }
        for(int i=0;i<40;i++)
        {
            for(Character ch:l)
            {
                System.out.print(ch);
            }
            System.out.println();
            l.remove(0);
        }
    }

}
