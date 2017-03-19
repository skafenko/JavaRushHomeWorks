package com.javarush.test.level19.lesson10.bonus01;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//Графическое представление
// http://info.javarush.ru/JavaRush_tasks_discussion/2016/02/14/level19-lesson10-bonus01-%D0%93%D1%80%D0%B0%D1%84%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%BF%D0%BE%D1%8F%D1%81%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-%D1%83%D1%81%D0%BB%D0%BE%D0%B2%D0%B8%D1%8F-%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8-.html


/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        List<String> file1Read =  readFile(file1);
        List<String> file2Read = readFile(file2);

        lines = insertCommonList(file1Read, file2Read);

        for (LineItem item : lines)
        {
            System.out.println(item);
        }
    }

    private static List<LineItem> insertCommonList(List<String> file1, List<String> file2)
    {
        List<LineItem> result = new ArrayList<>();
        int indexFile1 = 0;
        int indexFile2 = 0;

        while (indexFile1 < file1.size() && indexFile2 < file2.size())
        {
            String lineFromFile1 = file1.get(indexFile1);
            String lineFromFile2 = file2.get(indexFile2);

            if (lineFromFile1.equals(lineFromFile2)) {
                result.add(new LineItem(Type.SAME, lineFromFile1));
                indexFile1++;
                indexFile2++;
            }
            else if (!lineFromFile1.equals(lineFromFile2) && (indexFile2 + 1) < file2.size())
            {
                if (!lineFromFile1.equals(file2.get(indexFile2 + 1)))
                {
                    result.add(new LineItem(Type.REMOVED, lineFromFile1));
                    indexFile1++;
                }
                else
                {
                    result.add(new LineItem(Type.ADDED, lineFromFile2));
                    indexFile2++;
                }
            }
        }
        if (indexFile1 < file1.size())
            result.add(new LineItem(Type.REMOVED, file1.get(indexFile1)));
        else if (indexFile2 < file2.size())
            result.add(new LineItem(Type.ADDED, file2.get(indexFile2)));

        return result;
    }

    public static List<String> readFile(String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<String> result = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null)
        {
            result.add(line);
        }
        reader.close();
        return result;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "line='" + line + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
