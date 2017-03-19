package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

//test
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

              if (word.matches(".*\\d+.*"))
              {
                  resultWords.add(word);
              }
            }
        }
        reader.close();

        PrintWriter writer = new PrintWriter(file2);
        for (String word : resultWords) {
            writer.print(word + " ");
        }
        writer.close();
    }
}
