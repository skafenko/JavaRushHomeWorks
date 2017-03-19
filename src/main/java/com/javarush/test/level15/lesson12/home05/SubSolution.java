package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Mykhailo on 17.02.2016.
 */
public class SubSolution extends Solution
{
    SubSolution(short i) {
        super(i);
    }

    SubSolution(int i) {
        super(i);
    }

    SubSolution(long l) {
        super(l);
    }

    public SubSolution(Integer i) {
        super(i);
    }

    public SubSolution(String s) {
        super(s);
    }

    public SubSolution(Long l) {
        super(l);
    }

    protected SubSolution(byte b) {
        super(b);
    }

    protected SubSolution(float f) {
        super(f);
    }

    protected SubSolution(double d) {
        super(d);
    }
    private SubSolution(double d, float f)
    {
        super(d);
    }
    private SubSolution(float f, float f1)
    {
        super(f);
    }
    private SubSolution(byte b, float f)
    {
        super(b);
    }

}
