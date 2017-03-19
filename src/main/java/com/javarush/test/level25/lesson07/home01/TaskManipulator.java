package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String threadName;

    @Override
    public void run() {
        try {
            System.out.println(threadName);
            while (!thread.isInterrupted()) {
                System.err.println(threadName);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this.threadName);
        run();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
