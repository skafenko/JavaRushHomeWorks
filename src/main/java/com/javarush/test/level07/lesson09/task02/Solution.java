package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list=new ArrayList<String>();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            list.add(scanner.nextLine());
        }
        list.remove(2);
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(3-i));
        }

    }
}
