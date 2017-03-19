package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


// як считувать строки з вайла v одну строку???
//class File...ждем
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready())
        {
            String str = fileReader.readLine();
            if (Integer.parseInt(str) % 2 == 0)
                list.add(Integer.valueOf(str));
        }
        Collections.sort(list);
        for (Integer item : list)
        {
            System.out.println(item);
        }
    }
}
