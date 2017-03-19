package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();

        Scanner scannerFile = new Scanner(new FileReader(fileName1));
        StringBuilder builder = new StringBuilder();
        while (scannerFile.hasNext())
        {
            builder.append(scannerFile.nextLine());
        }
        scannerFile.close();
        String result = String.valueOf(builder).replaceAll("[\\p{Punct}\\s]+", "");
        FileWriter writer = new FileWriter(fileName2);
        writer.write(result);
        writer.close();
    }
}
