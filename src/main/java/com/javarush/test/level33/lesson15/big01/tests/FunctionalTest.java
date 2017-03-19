package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mykhailo on 16.11.2016.
 */
public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String str1 = Helper.generateRandomString();
        String str2 = Helper.generateRandomString();
        String str3 = new String(str1);

        long id1 = shortener.getId(str1);
        long id2 = shortener.getId(str2);
        long id3 = shortener.getId(str3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);

        String result1 = shortener.getString(id1);
        String result2 = shortener.getString(id2);
        String result3 = shortener.getString(id3);

        Assert.assertEquals(result1, str1);
        Assert.assertEquals(result2, str2);
        Assert.assertEquals(result3, str3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
    public void testFileStorageStrategy() {
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
