package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);
        String result = array.toString();

        Scanner scanner = new Scanner(result);
        int reclamaAfterEveryLine = 2;
        int amountLine = 0;
        final String reclama = "JavaRush - курсы Java онлайн";
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            amountLine++;
            if (amountLine == reclamaAfterEveryLine)
            {
                amountLine = 0;
                System.out.println(reclama);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
