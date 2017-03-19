package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
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
        String file3 = scanner.nextLine();

        FileInputStream stream2 = new FileInputStream(file2);
        FileInputStream stream3 = new FileInputStream(file3);
        FileOutputStream stream1 = new FileOutputStream(file1);

        while (stream2.available() > 0)
        {
            int data2 = stream2.read();
            stream1.write(data2);
        }
        while (stream3.available() > 0)
        {
            int data3 = stream3.read();
            stream1.write(data3);
        }
        scanner.close();
        stream1.close();
        stream2.close();
        stream3.close();
    }
}
