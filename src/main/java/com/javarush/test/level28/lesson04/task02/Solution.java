package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс amy.Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {

    private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();


    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return threadLocalRandom.nextInt(from, to);
    }

    public static double getRandomDouble() {
        return threadLocalRandom.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return threadLocalRandom.nextLong(n);
    }
}
