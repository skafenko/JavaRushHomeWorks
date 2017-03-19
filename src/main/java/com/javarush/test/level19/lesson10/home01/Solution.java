package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        TreeMap<String, Double> resultMap = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (reader.ready())
        {
            String line = reader.readLine();
            int indexSpace = line.indexOf(" ");
            String key = line.substring(0, indexSpace);
            Double value = Double.valueOf(line.substring(indexSpace).trim());
            if (resultMap.containsKey(key))
            {
                value += resultMap.get(key);
            }

            resultMap.put(key, value);
        }

        for (Map.Entry<String, Double> map : resultMap.entrySet())
        {
            String key = map.getKey();
            String value = String.valueOf(map.getValue());
            System.out.println(key + " " + value);
        }
        reader.close();

    }
}
