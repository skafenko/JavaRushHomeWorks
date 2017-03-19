package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        byte[] buffer = new byte[inputStream.available()];
        byte[] flipBuffer = new byte[inputStream.available()];

        while (inputStream.available() > 0)
        {
            int data = inputStream.read(buffer);
            for (int i = buffer.length - 1, k = 0; i >= 0; i--, k++)
            {
                    flipBuffer[k] = buffer[i];

            }
            outputStream.write(flipBuffer, 0, data);
        }
        scanner.close();
        inputStream.close();
        outputStream.close();

    }
}
