package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.
если нет, то в папку 'new' сосдавать не нужно!!!!!!!!!!!!

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска amy.Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            String fileName = args[0];
            String zipArchive = args[1];


            if (fileName == null || zipArchive == null) {
                return;
            }
            String substring = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

            Map<String, byte[]> result = new HashMap<>();

            ZipInputStream in = new ZipInputStream(new FileInputStream(zipArchive));
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                String name = entry.getName();
                if (entry.isDirectory()) {
                    continue;
                } else {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    if (!name.equals(substring)) {
                        int read ;
                        while ((read = in.read()) != -1) {
                            outputStream.write(read);
                        }
                        outputStream.flush();
                        result.put(name, outputStream.toByteArray());
                    } else {
                        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                        int read ;
                        while ((read = inputStream.read()) != -1) {
                            outputStream.write(read);
                        }
                        outputStream.flush();
                        result.put("new\\" + substring, outputStream.toByteArray());
                    }
                }
            }



            final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipArchive));
            for (Map.Entry<String, byte[]> item : result.entrySet()) {
                out.putNextEntry(new ZipEntry(item.getKey()));
                out.write(item.getValue());
                out.closeEntry();
            }

            out.flush();
            out.close();
            in.close();
        }
    }

}
