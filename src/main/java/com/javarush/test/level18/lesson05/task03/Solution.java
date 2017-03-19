package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String fileName3 = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream1 = new FileOutputStream(fileName2);
        FileOutputStream outputStream2 = new FileOutputStream(fileName3);

        int amountOfByte = (int) Math.ceil((double) inputStream.available() / 2);
        byte[] buffer = new byte[amountOfByte];
        while (inputStream.available() > 0)
        {
            int data = inputStream.read(buffer);
            outputStream1.write(buffer, 0, data);

            int data1 = inputStream.read(buffer);
            outputStream2.write(buffer, 0, data1);
        }
        scanner.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
