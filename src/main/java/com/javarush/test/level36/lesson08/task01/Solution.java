package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0)
            return;

        Set<Character> result = new TreeSet<>();
        String fileName = args[0];
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        int ch;
        while ((ch = in.read()) != -1) {
            char c = (char) ch;
            String str = String.valueOf(c).toLowerCase();
            if (Pattern.matches("[\\p{Punct}\\s\\-,.\\r\\n]", str))
                continue;
            result.add(str.charAt(0));
        }

        in.close();

        int i = 0;
        for (Character character : result) {
            if (i == 5)
                break;
            System.out.print(character);
            i++;
        }
    }
}
