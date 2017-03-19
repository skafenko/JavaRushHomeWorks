package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(file1));
        StringBuilder builder = new StringBuilder();
        while (readerFile.ready())
        {
            builder.append(readerFile.readLine());
        }

        readerFile.close();
        String result1 = String.valueOf(builder);
        String[] doub = result1.split("\\s+");
        builder = new StringBuilder();
        for (String item : doub)
        {
            builder.append(String.valueOf((int) Math.round(Double.parseDouble(item))) + " ");
        }
        String result2 = String.valueOf(builder);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        writer.write(result2);
        writer.close();
    }
}
