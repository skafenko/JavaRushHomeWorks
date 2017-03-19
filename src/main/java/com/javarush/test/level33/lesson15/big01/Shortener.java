package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by Mykhailo on 13.11.2016.
 */
public class Shortener {

    private Long lastId = 0L;

    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        Long result = storageStrategy.getKey(string);

        if (result == null) {
            result = ++lastId;
            storageStrategy.put(result, string);
        }
        return result;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
