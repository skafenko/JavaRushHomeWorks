package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Mykhailo on 29.01.2016.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Computer()
    {
        keyboard = new Keyboard();
        monitor = new Monitor();
        mouse = new Mouse();
    }
}
