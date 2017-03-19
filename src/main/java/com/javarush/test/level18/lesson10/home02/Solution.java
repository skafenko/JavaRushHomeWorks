package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0)
        {
            final String fileName = args[0];

            int amountSigil = 0;

            int amountSpace = 0;

            FileReader reader = new FileReader(fileName);

            while (reader.ready())
            {
                int data = reader.read();
                if ((char) data == ' ')
                    amountSpace++;

                amountSigil++;
            }

            double result = ((double) amountSpace / amountSigil) * 100;

            result = Math.round(result * 100.0) / 100.0;

            System.out.println(result);

            reader.close();
        }
    }
}
