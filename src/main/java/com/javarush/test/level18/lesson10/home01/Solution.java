package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileReader;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        int minHachcodeBig = (int) 'A';
        int maxHachcodeBig = (int) 'Z';
        int minHachcodeSmall = (int) 'a';
        int maxHachcodeSmall = (int) 'z';

        if (args.length > 0)
        {
            String fileName = args[0];
            FileReader reader = new FileReader(fileName);
            int amountEnglishAlphabet = 0;
            while (reader.ready())
            {
                int hachCode = reader.read();
                if (hachCode >= minHachcodeBig && hachCode <= maxHachcodeBig || hachCode >= minHachcodeSmall && hachCode <= maxHachcodeSmall)
                    amountEnglishAlphabet++;
            }
            reader.close();
            System.out.println(amountEnglishAlphabet);
        }
    }
}
