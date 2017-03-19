package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        File file = new File(root);
        if (!file.isDirectory()) {
            return result;
        }
        Queue<File> queue = new ArrayDeque<>();
        queue.add(file);
        File polledFile;
        while ((polledFile = queue.poll()) != null) {
            File[] files = polledFile.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    queue.add(f);
                } else if (f.isFile()) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        String root = "D:\\Фільми";
        List<String> list = getFileTree(root);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
