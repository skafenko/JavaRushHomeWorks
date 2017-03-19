package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

//problem with coding utf-8
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (reader.ready())
        {
            String string = reader.readLine();
            System.out.println(string);
            int amount = 0;
            for (String item : words)
            {
                if (string.contains(item))
                    amount++;
            }
            if (amount == 2)
                System.out.println(string);
        }
        reader.close();
    }
}
