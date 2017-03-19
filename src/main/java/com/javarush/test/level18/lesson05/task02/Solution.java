package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','---44
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int amountOfChar = 0;
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            if (data == 44)
                amountOfChar++;
        }
        System.out.println(amountOfChar);
        inputStream.close();
        scanner.close();
    }

}
