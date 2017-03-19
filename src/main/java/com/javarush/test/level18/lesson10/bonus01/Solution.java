package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static int key = 1;
    public static void main(String[] args) {
        String command = args[0];
        switch (command){
            case "-e":
                encrypt(args[1], args[2]);
                break;
            case "-d":
                decrypt(args[1], args[2]);
                break;
        }
    }

    private static void encrypt(String fileName, String fileOutputName)
    {
        try {
            FileInputStream stream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileOutputName);
            while(stream.available() > 0)
            {
                int data = stream.read();
                outputStream.write(data + key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String fileName, String fileOutputName)
    {
        try {
            FileInputStream stream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileOutputName);
            while(stream.available() > 0)
            {
                int data = stream.read();
                outputStream.write(data - key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
