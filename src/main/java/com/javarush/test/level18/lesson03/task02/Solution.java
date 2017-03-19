package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        int minByte = fileInputStream.read();//если файл пустой то переменная ровна -1
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            minByte = data > minByte ? minByte : data;
        }
        System.out.println(minByte);
        reader.close();
        fileInputStream.close();
    }
}
