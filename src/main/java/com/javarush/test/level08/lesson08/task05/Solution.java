package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key1", "vova");
        map.put("key2", "vova");
        map.put("key3", "flat");
        map.put("key4", "great");
        map.put("key5", "final");
        map.put("key6", "final");
        map.put("key7", "final");
        map.put("key8", "dog");
        map.put("key9", "warm");
        map.put("key10", "warm");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copyMap = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copyMap.entrySet()) {
            String name = pair.getValue();
            int i = 0;
            for (Map.Entry<String, String> pp : copyMap.entrySet()) {
                String name1 = pp.getValue();
                if (name.equals(name1))
                    i++;

            }
            if (i > 1) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
        return;
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }



}
