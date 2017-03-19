package com.javarush.test.level32.lesson04.home01;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        if (is == null) {
            return writer;
        }

        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8.displayName());
        char[] c = new char[1024];
        while (reader.ready()) {
            int len = reader.read(c);
            writer.write(c, 0, len);
        }

        reader.close();
        writer.flush();
        writer.close();

        return writer;
    }
}
