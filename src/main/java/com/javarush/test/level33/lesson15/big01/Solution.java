package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mykhailo on 13.11.2016.
 */
public class Solution {

    public static void main(String[] args) {
//        testStrategy(new HashMapStorageStrategy(), 10_000);
//        testStrategy(new OurHashMapStorageStrategy(), 10_000);
//        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
//        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
    }





    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String string : strings) {
            result.add(shortener.getId(string));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        while (elementsNumber > 0) {
            strings.add(Helper.generateRandomString());
            elementsNumber--;
        }
        Shortener shortener = new Shortener(strategy);

        long start = new Date().getTime();
        Set<Long> keys = getIds(shortener, strings);
        long time = new Date().getTime() - start;
        Helper.printMessage("getId - " + time + " ms");

        start = new Date().getTime();
        Set<String> stringsAfterTest = getStrings(shortener, keys);
        time = new Date().getTime() - start;
        Helper.printMessage("getStrings - " + time + " ms");

        if (strings.size() == stringsAfterTest.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
