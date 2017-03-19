package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();



    public static void main(String[] args)
    {
        System.out.println(labels);
    }

    static
    {
        labels.put(3.4, "jkdslfj");
        labels.put(4.4, "jkd");
        labels.put(5.4, "slfj");
        labels.put(6.4, "fj");
        labels.put(7.4, "j");
    }
}
