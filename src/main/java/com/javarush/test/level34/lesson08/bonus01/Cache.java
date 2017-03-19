package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V value = cache.get(key);
        if (value == null) {
            value = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, value);
        }
        return value;
    }

    public boolean put(V obj) {
        try {
            Method getKey = obj.getClass().getMethod("getKey");
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj);
            cache.put(key, obj);
            getKey.setAccessible(false);
            return true;
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
