package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length == 2) {
            String directoryPath = args[0];
            String resultPath = args[1];
            if (directoryPath == null || resultPath == null) {
                return;
            }

            File directory = new File(directoryPath);
            File fileForsave = new File(resultPath);

            List<File> files = new ArrayList<>();
            if (directory.isDirectory()) {
                mainMethod(files, directory);
            }

            File newFile = new File(fileForsave.getParentFile(), "allFilesContent.txt");
            fileForsave.renameTo(newFile);

            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                   return o1.getName().compareTo(o2.getName());
                }
            });


            try(FileOutputStream out = new FileOutputStream(newFile)) {
                for (File file : files) {
                    try (FileInputStream in = new FileInputStream(file)) {
                        while (true) {
                            int b = in.read();
                            if (b == -1)
                                break;

                            out.write(b);
                        }
                    }
                    out.write('\n');

                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            newFile.renameTo(fileForsave);

        }

    }

    private static void mainMethod(List<File> list, File directoryFile) {
        File[] files = directoryFile.listFiles();
        if (files.length == 0) {
            directoryFile.delete();
        }
        for (File file : files) {
            if (file.isDirectory()) {
                mainMethod(list, file);
            } else if (file.isFile()) {
                long lengthInByte = file.length();
                if (lengthInByte > 50) {
                    file.delete();
                } else {
                    list.add(file);
                }
            }
        }
    }
}
