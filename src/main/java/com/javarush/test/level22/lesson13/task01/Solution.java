package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        int countTokens = tokenizer.countTokens();
        String[] tokens = new String[countTokens];
        int index = 0;
        while (tokenizer.hasMoreTokens() && index < countTokens)
        {
            tokens[index] = tokenizer.nextToken();
            index++;
        }
        return tokens;
    }

    public static void main(String[] args) {
        String[] elements = getTokens("level22.lesson13.task01", ".");
        for (String elem : elements)
            System.out.println(elem);

    }
}
