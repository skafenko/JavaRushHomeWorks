package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        ArrayList<String> resultWords = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {

                if (word.length() > 6) {
                    resultWords.add(word);
                }
            }
        }
        reader.close();

        PrintWriter writer = new PrintWriter(file2);
        for (int i = 0; i < resultWords.size(); i++) {

            if (i == 0) {
                writer.print(resultWords.get(i));
            }
            else
                writer.print("," + resultWords.get(i));
        }
        writer.close();
    }
}
