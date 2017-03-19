package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    private static int lengthId = 8;
    private static int lengthProductName = 30;
    private static int lengthPrice = 8;
    private static int lengthQuantity = 4;

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();


        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

        int idArgs = Integer.parseInt(args[1]);
        while (readerFile.ready())
        {
            String readLine = readerFile.readLine();
            int idRead = Integer.parseInt(readLine.substring(0, lengthId).trim());

            if (idRead == idArgs)
            {
                if ("-u".equals(args[0]))
                    readLine = update(args, idRead);
                else if ("-d".equals(args[0]))
                {
                    continue;
                }

            }
            readLine = strToWrite(String.valueOf(idRead), lengthId) + readLine.substring(lengthId);
            lines.add(readLine);
        }
        readerFile.close();


        PrintWriter print = new PrintWriter(new FileWriter(fileName));
        for (String line : lines)
        {
            print.println(line);
        }
        print.close();
    }


    private static String update(String[] args, int idRead)
    {
        String id = strToWrite(String.valueOf(idRead), lengthId);
        String productName = strToWrite(args[2], lengthProductName);
        String price = strToWrite(args[3], lengthPrice);
        String quantity = strToWrite(args[4], lengthQuantity);

        return id + productName + price + quantity;
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
