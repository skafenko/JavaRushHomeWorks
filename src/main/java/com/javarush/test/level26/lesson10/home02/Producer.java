package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int counter = 1;
        try {
            while (true)
            {
                System.out.println(String.format("Some text for %d", counter++));
                Thread.sleep(500);
            }
        }  catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
        }
    }
}