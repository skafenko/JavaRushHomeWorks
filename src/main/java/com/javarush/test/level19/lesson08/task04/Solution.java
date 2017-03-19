package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();



    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);


        String[] elements = result.split("\\s+");
        int firstNumber = Integer.parseInt(elements[0]);
        int secondNumber = Integer.parseInt(elements[2]);
        String glyph = elements[1];
        switch (glyph)
        {
            case "+":
                System.out.println(elements[0] + " " + elements[1] + " " + elements[2] + " " + elements[3] + " " + Integer.toString(firstNumber + secondNumber));
                break;
            case "-":
                System.out.println(elements[0] + " " + elements[1] + " " + elements[2] + " " + elements[3] + " " + Integer.toString(firstNumber - secondNumber));
                break;
            case "*":
                System.out.println(elements[0] + " " + elements[1] + " " + elements[2] + " " + elements[3] + " " + Integer.toString(firstNumber * secondNumber));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

