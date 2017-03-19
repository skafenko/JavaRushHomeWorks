package com.javarush.test.level22.lesson09.task02;

import java.util.Map;
import java.util.TreeMap;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> parameter : params.entrySet())
        {
            String value = parameter.getValue();
            if (value == null) continue;

            String key = parameter.getKey();
            if (builder.length() == 0)
                builder.append(key + " = " + "'" + value + "'");
            else
                builder.append(" and " + key + " = " + "'" + value + "'");

        }
        return builder;
    }

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getCondition(map).toString());
    }
}
