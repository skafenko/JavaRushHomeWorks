package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Думать дальше..
public class Solution {
    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        Scanner scannerFile = new Scanner(new FileReader(fileName));

        String str = "";
        while (scannerFile.hasNext())
        {
           str += scannerFile.nextLine() + " ";
        }
        scannerFile.close();
        int world = 0;
        String[] words = str.split("[\\p{Punct}\\s]+");
        for (int i = 0; i < words.length; i++)
        {
            if (words[i].equals("world"))
            {
                world++;
            }
        }
        System.out.println(world);

    }
}
