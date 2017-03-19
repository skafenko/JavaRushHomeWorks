package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        try
        {
            InputStream file = new FileInputStream(fileName);
            while (file.available() > 0)
            {
                int date = file.read();
                System.out.print((char)date);
            }
            file.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}
