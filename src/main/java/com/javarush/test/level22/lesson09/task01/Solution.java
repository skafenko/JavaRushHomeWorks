package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/

//читать обсуждения--так то роботает
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();


        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        StringBuilder builder = new StringBuilder();
        String line;
        while (reader.ready())
        {
            line = reader.readLine();
            String[] words = line.trim().split("\\s+");
            for (String word : words)
            {
                builder.append(word + " ");
            }
        }
        reader.close();

        StringBuilder word;
        int indexSpace = builder.indexOf(" ");
        int indexFrom = 0;


        while(!builder.toString().trim().equals(""))
        {
            Pair pair = new Pair();
            word = new StringBuilder();
            word.append(builder.subSequence(indexFrom, indexSpace));
            pair.first = word.toString();
            word.reverse();
            pair.second = word.toString();

            builder.delete(indexFrom, indexSpace + 1);

            int indexFirstStart = builder.indexOf(pair.second);
            if (indexFirstStart == -1)
            {
                indexSpace = builder.indexOf(" ");
            }
            else
            {
                result.add(pair);
                builder.delete(indexFirstStart, indexFirstStart + pair.first.length() + 1);
                indexSpace = builder.indexOf(" ");
            }

            if (indexSpace == -1)
                break;
        }

        for (Pair p : result)
        {
            System.out.println(p.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
