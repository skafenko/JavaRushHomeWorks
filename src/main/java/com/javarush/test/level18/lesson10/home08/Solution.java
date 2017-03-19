package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        while (!"exit".equals(file))
        {
            ReadThread readThread = new ReadThread(file);
            readThread.start();
            file = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        private String fileName;
        private int ourByte;
        Map<Integer, Integer> bytu = new HashMap<Integer, Integer>();
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream stream = new FileInputStream(fileName);
                if (stream.available() == 0) {//if file is empty
                    resultMap.put(fileName, 0);
                    stream.close();
                }

                else{
                    while (stream.available() > 0)
                    {
                        int data = stream.read();
                        if (!bytu.containsKey(data)) bytu.put(data, 1);
                        else{
                            bytu.put(data, bytu.get(data) + 1);
                        }
                    }
                    int maxRepeat = 0;
                    for (Map.Entry<Integer, Integer> iterator : bytu.entrySet())
                    {
                        Integer key = iterator.getKey();
                        Integer value = iterator.getValue();
                        if (value > maxRepeat)
                        {
                            maxRepeat = value;
                            ourByte = key;
                        }
                    }
                    resultMap.put(fileName, ourByte);
                    stream.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
