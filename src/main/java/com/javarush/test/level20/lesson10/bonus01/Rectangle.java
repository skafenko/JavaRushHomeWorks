package com.javarush.test.level20.lesson10.bonus01;

/**
 * Created by Mykhailo on 28.06.2016.
 */
public class Rectangle
{
    private int start;
    private int end;

    public Rectangle(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
