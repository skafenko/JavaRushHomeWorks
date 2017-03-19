package com.javarush.test.level31.lesson06.bonus01;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            String resultFileName = args[0];
            Path pathFileName = Paths.get(resultFileName);
            if (Files.notExists(pathFileName.getParent())) {
                Files.createDirectories(pathFileName.getParent());
            }

            List<String> fileNameParts = new ArrayList<>();

            for (int i = 1; i < args.length; i++) {
                fileNameParts.add(args[i]);
            }

            Collections.sort(fileNameParts);

            for (String fileNamePart : fileNameParts) {
                try (ZipInputStream in = new ZipInputStream(new FileInputStream(fileNamePart))) {
                    ZipEntry entry;
                    while ((entry = in.getNextEntry()) != null) {
                        byte[] b = read(in);
                        Files.write(pathFileName, b, StandardOpenOption.APPEND);
                        in.closeEntry();
                    }
                }
            }
        }
    }

    private static byte[] read(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int i;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
        out.flush();
        return out.toByteArray();
    }
}
