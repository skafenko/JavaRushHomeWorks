package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        FileInputStream fileReader = new FileInputStream(file1);
        FileOutputStream fileWriter = new FileOutputStream(file2);
        int count = 0;
        while (fileReader.available() > 0)
        {
            int data = fileReader.read();
            count++;
            if (count % 2 == 0)
            {
                fileWriter.write(data);
            }

        }

        scanner.close();
        fileReader.close();
        fileWriter.close();

    }
}
