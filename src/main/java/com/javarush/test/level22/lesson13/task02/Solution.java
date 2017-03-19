package com.javarush.test.level22.lesson13.task02;

import javax.xml.crypto.Data;
import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileNameRead = args[0];
        String fileNameWrite = args[1];

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameRead)));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileNameWrite));
        while (in.ready())
        {
            String read = in.readLine();
            byte[] buffer = read.getBytes("Windows-1251");
            String write = new String(buffer, "UTF-8");
            out.write(write);
        }
        in.close();
        out.flush();
        out.close();
    }
}
