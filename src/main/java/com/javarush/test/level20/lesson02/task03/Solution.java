package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //OutputStream outputStream = new FileOutputStream(fileName);
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintStream stream = new PrintStream(outputStream);
        for (Map.Entry<String, String> map : properties.entrySet())
        {
            stream.println(map.getKey() + " = " + map.getValue());
        }
        stream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready())
        {
            String line = reader.readLine().trim();
            String checkAnotherString = line;
            while (checkAnotherString.endsWith("\\"))
            {
                checkAnotherString = reader.readLine().trim();
                line = line + checkAnotherString;
            }
            line = line.replaceAll("\\\\", "");
            if (!line.startsWith("#") && !line.startsWith("!") && !line.trim().equals(""))
            {
                String[] keyAndValue = new String[2];
                if (line.matches(".*?[=:].*?"))
                {
                    keyAndValue = line.split("\\s?[=:]\\s?", 2);
                }
                else
                    keyAndValue = line.split("\\s?[=:\\s]{1}\\s?", 2);
                if (keyAndValue[1].matches("u[A-z\\d]{4}$")) keyAndValue[1] = "\\" + keyAndValue[1];
                properties.put(keyAndValue[0], keyAndValue[1]);
            }
            else continue;
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        for (Map.Entry<String, String> map : properties.entrySet())
        {
            System.out.println(map.getKey() + " = " + map.getValue());
        }
    }
}
