package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Mykhailo on 21.08.2016.
 */
public class MyThread extends Thread {
    private static int priority = Thread.MIN_PRIORITY;
    ThreadGroup group = getThreadGroup();

    public MyThread() {
        setPriority();
    }


    public MyThread(Runnable target) {
        super(target);

        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }

    private void setPriority() {
        if (group != null && group.getMaxPriority() < priority)
            setPriority(group.getMaxPriority());
        else
            setPriority(priority);

        if (priority + 1 > Thread.MAX_PRIORITY)
            priority = Thread.MIN_PRIORITY;
        else
            priority++;
    }

}
