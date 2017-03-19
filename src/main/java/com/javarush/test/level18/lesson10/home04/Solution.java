package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        FileInputStream stream = new FileInputStream(file1);
        byte[] buffer = new byte[stream.available()];
        while (stream.available() > 0)
        {
            stream.read(buffer);
        }
        stream.close();
        scanner.close();

        FileInputStream stream1 = new FileInputStream(file2);
        FileOutputStream stream2 = new FileOutputStream(file1);
        while (stream1.available() > 0)
        {
            int data = stream1.read();
            stream2.write(data);
        }
        stream2.write(buffer);
        stream1.close();
        stream2.close();
    }
}
