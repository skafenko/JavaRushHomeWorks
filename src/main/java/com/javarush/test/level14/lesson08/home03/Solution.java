package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        //тут цикл по чтению ключей, пункт 1
        while ("user".equals(key) || "looser".equals(key) || "coder".equals(key) || "proger".equals(key))
        {
        //создаем объект, пункт 2
            if ("user".equals(key))
            {
                person = new Person.User();
                doWork(person); //вызываем doWork
                key = reader.readLine();
            }
            else if ( "looser".equals(key))
            {
                person = new Person.Looser();
                doWork(person);
                key = reader.readLine();
            }
            else if ( "coder".equals(key))
            {
                person = new Person.Coder();
                doWork(person);
                key = reader.readLine();
            }
            else  if ( "proger".equals(key))
            {
                person = new Person.Proger();
                doWork(person);
                key = reader.readLine();
            }
        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
        if (person instanceof Person.User)
        {
            ((Person.User) person).live();
        }
        else if (person instanceof Person.Looser)
        {
            ((Person.Looser) person).doNothing();
        }
        else if (person instanceof Person.Coder)
        {
            ((Person.Coder) person).coding();
        }
        else if (person instanceof Person.Proger)
        {
            ((Person.Proger) person).enjoy();
        }
    }
}
