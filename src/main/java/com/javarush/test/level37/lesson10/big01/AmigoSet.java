package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Mykhailo on 03.12.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;


    public AmigoSet() {
        map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<E, Object>((int) Math.max(16, collection.size() / .75f));
        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }
    private void writeObject(java.io.ObjectOutputStream s) throws IOException {

        s.defaultWriteObject();

        s.writeObject(map.size());
        for(E e:map.keySet()){
            s.writeObject(e);
        }
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }


    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        int size = (int)s.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)s.readObject());
        }
        int capacity = (int)s.readObject();
        float loadFactor = (float)s.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }

    @Override
    public Object clone() {
        Set<E> sets = ((HashMap<E, Object>) map.clone()).keySet();
        return new AmigoSet<E>(sets);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public void clear() {
        map.keySet().clear();
    }


    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }


    @Override
    public boolean add(E e) {
        try {
            map.put(e, PRESENT);
            return true;
        } catch (Exception e1) {
            return false;
        }
    }

}
