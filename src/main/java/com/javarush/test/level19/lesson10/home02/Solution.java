package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile = args[0];
        TreeMap<String, Double> resultMap = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
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

        String resultName = null;
        Double maxDouble = 0.0;
        for (Map.Entry<String, Double> map : resultMap.entrySet())
        {
            String key = map.getKey();
            Double value = map.getValue();
            if (value > maxDouble)
            {
                maxDouble = value;
                resultName = key;
            }
        }
        System.out.println(resultName);
        reader.close();
    }
}
