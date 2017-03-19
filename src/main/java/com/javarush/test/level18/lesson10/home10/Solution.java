package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> fileNames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("end"))
        {
            fileNames.add(fileName);
            fileName = reader.readLine();
        }
        reader.close();
        Collections.sort(fileNames);

        String path = fileNames.get(0);
        String fileCreate = path.substring(0, path.lastIndexOf(".part1"));
        File f = new File(fileCreate);
        f.createNewFile();



        FileOutputStream outputStream = new FileOutputStream(fileCreate);
        for (String file : fileNames)
        {
            FileInputStream stream = new FileInputStream(file);
            byte[] buffer = new byte[stream.available()];
            stream.read(buffer);
            stream.close();
            outputStream.write(buffer);
            outputStream.flush();
        }
        outputStream.close();
    }
}
