package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("dfs", "sdf");
        map.put("sf", "sdfs");
        map.put("sdf", "sdf");
        map.put("d", "dd");
        map.put("f", "gg");
        map.put("g", "g");
        map.put("h", "j");
        map.put("j", "j");
        map.put("k", "k");
        map.put("l", "l");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int i = 0;
        for (String value : map.values()) {
            if (name.equals(value))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        if (map.containsKey(lastName))
            return 1;
        return 0;

    }
}
