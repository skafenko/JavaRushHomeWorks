package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
        System.out.println(s);
        s = s.replace(".", "!");
        System.out.println(s);
        writer.write(s);
        reader.close();
        writer.close();
    }
}
