package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mykhailo on 16.11.2016.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = new Date().getTime();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return new Date().getTime() - start;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = new Date().getTime();
        for (Long key : ids) {
            strings.add(shortener.getString(key));
        }
        return new Date().getTime() - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> origLongs1 = new HashSet<>();
        Set<Long> origLongs2 = new HashSet<>();

        int amount = 10_000;
        for (int i = 0; i < amount; i++)
            origStrings.add(Helper.generateRandomString());

        long timeIds1 = getTimeForGettingIds(shortener1, origStrings, origLongs1);
        long timeIds2 = getTimeForGettingIds(shortener2, origStrings, origLongs2);
        Assert.assertTrue(timeIds1 > timeIds2);

        long timeStrs1 = getTimeForGettingStrings(shortener1, origLongs1, new HashSet<String>());
        long timeStrs2 = getTimeForGettingStrings(shortener2, origLongs2, new HashSet<String>());
        Assert.assertEquals(timeStrs1, timeStrs2, 5);

    }
}
