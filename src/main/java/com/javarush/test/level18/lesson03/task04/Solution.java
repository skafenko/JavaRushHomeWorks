package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

//реши task 03
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available() > 0)
        {
            fileInputStream.read(buffer);
        }
        String result = "";
        int minReapet = 1;
        for (int i = 0; i < buffer.length; i++)
        {
            int amountreapet = 0;
            for (int k = 0; k < buffer.length; k++)
            {
                if (buffer[i] == buffer[k])
                {
                    amountreapet++;

                }
            }
            if (amountreapet < minReapet)
            {
                minReapet = amountreapet;
                result = String.valueOf((int) buffer[i]);
            }
            else if (amountreapet == minReapet)
            {
                result += String.valueOf((int) buffer[i]) + " ";
            }
        }
        System.out.println(result);
        reader.close();
        fileInputStream.close();
    }
}
