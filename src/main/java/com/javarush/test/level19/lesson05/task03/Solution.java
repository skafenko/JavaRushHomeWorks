package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        String s = "";
        while (reader.ready())
        {
            int data = reader.read();
            s += (char) data;
        }
        String[] numeric = s.split("\\s+");
        for (int i = 0; i < numeric.length; i++)
        {
            if (numeric[i].matches("[0-9]+"))
            {
                writer.write(numeric[i] + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
