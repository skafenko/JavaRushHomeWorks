package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] element = string.split(" ");
        if (element.length < 5) throw new TooShortStringException();
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < 5; i++)
        {
            if (i == 4)
                builder.append(element[i]);
            else
                builder.append(element[i] + " ");
        }
        return builder.toString();
    }

    public static class TooShortStringException extends Exception {
    }
}
