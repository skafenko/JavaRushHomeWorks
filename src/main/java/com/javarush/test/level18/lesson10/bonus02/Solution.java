package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;


public class Solution {
    private static int lengthId = 8;
    private static int lengthProductName = 30;
    private static int lengthPrice = 8;
    private static int lengthQuantity = 4;
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

        String readId = readerFile.readLine();
        while (readerFile.ready())
        {
            readId = readerFile.readLine();
        }

        if (readId == null)
            readId = "1";
        else
        {
            int id = Integer.parseInt(readId.substring(0, lengthId).trim()) + 1;
            readId = String.valueOf(id);
        }

        String id = strToWrite(readId, lengthId);
        String productName = strToWrite(args[1], lengthProductName);
        String price = strToWrite(args[2], lengthPrice);
        String quantity = strToWrite(args[3], lengthQuantity);

        String result = id + productName + price + quantity;

        writer.println(result);
        writer.close();
    }


    private static String strToWrite(String id, int length)
    {
        String result = id;
        if (result.length() > length)
        {
            result = result.substring(0, length);
        }
        else
        {
            while (result.length() < length)
            {
                result += " ";
            }
        }
        return result;
    }
}
