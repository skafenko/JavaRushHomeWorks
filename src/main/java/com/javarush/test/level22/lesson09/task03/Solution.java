package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

abc cde cdf cdo fa mno opr opq rm qsc

cdo opr rm mno opq qsc cdf fa abc cde
Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/

// почитать коменти http://info.javarush.ru/JavaRush_tasks_discussion/2014/02/27/level22-lesson09-task03.html
public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] words = line.split("\\s");
            list.addAll(Arrays.asList(words));
        }
        scanner.close();

        String[] words = list.toArray(new String[0]);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder builder = new StringBuilder();

        if (words == null || words.length == 0)
           return builder;
        if (words.length == 1)
            return builder.append(words[0]);

        builder.append(words[0] + " ");

        for (int j = 1; j < words.length; j++)
        {
            if (builder.indexOf(words[j]) != -1)
                continue;
            int indexLastChar = words[j].length() - 1;
            char first = Character.toLowerCase(words[j].charAt(0));
            char last = Character.toLowerCase(words[j].charAt(indexLastChar));

            int indexSpace = builder.indexOf(" ");

            if (last == Character.toLowerCase(builder.charAt(0)))
            {
                builder.insert(0, words[j] + " ");
                continue;
            }
            while (indexSpace != -1)
            {
                if (indexSpace == builder.length() - 1 && first == Character.toLowerCase(builder.charAt(indexSpace - 1)))
                {
                    builder.append(words[j] + " ");
                    break;
                }
                else if (first == Character.toLowerCase(builder.charAt(indexSpace - 1))
                        && last == Character.toLowerCase(builder.charAt(indexSpace + 1)))
                {
                    builder.insert(indexSpace + 1, words[j] + " ");
                    break;
                }

                indexSpace = builder.indexOf(" ", indexSpace + 1);
            }

            if (j == words.length - 1 && builder.toString().split(" ").length != words.length)
            {
                j = 1;
            }

        }
        return builder.deleteCharAt(builder.length() - 1);
    }

}
