package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/


//все працює задать вопрос на форуме чого не принимаєт
public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static
    {
        threads.add(new Type1());
        threads.add(new Type2());
        threads.add(new Type3());
        threads.add(new Type4());
        threads.add(new Type5());
    }

    public static class Type1 extends Thread
    {
        public void run()
        {
            while(!isInterrupted())
            {

            }
        }
    }

    public static class Type2 extends Thread
    {
        public void run()
        {
            while(true)
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Type3 extends Thread
    {
        public void run()
        {
            while(!isInterrupted())
            {
                try
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Type4 extends Thread implements Message
    {
        public void run()
        {
            while(!isInterrupted())
            {

            }
        }

        @Override
        public void showWarning()
        {
            interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Type5 extends Thread
    {
        public static Integer suma = 0;
        public void run()
        {
            try {
                String n = reader.readLine();
                while(!n.equals("N"))
                {
                    suma += Integer.parseInt(n);
                    n = reader.readLine();
                }
                System.out.println(suma);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

    }
}
