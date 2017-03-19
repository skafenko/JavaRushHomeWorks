package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0)
        {
            Map<Integer, Integer> resultMap = new TreeMap<>();
            String fileName = args[0];
            FileReader reader = new FileReader(fileName);
            while (reader.ready())
            {
                int codeASCII = reader.read();
                if (!resultMap.containsKey(codeASCII))
                {
                    resultMap.put(codeASCII, 1);
                }
                else
                {
                    resultMap.put(codeASCII, resultMap.get(codeASCII) + 1);
                }
            }
            reader.close();
            for (Map.Entry<Integer, Integer> map : resultMap.entrySet())
            {
                int character = map.getKey();
                System.out.println((char) character + " " + map.getValue());
            }
        }

    }
}
