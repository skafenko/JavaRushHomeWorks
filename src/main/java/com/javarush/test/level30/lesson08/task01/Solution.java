package com.javarush.test.level30.lesson08.task01;

/* Найдем число 2 в максимальной степени
Реализуйте логику метода maxPowerOf2,
который должен возвращать число 2 в максимальной степени, которое получается поместить в переданное число
Аргументом maxPowerOf2 может быть только положительное число
Используйте только операции: 1)побитовые сдвиги, 2) присваивание, 3) побитовое ИЛИ
Не оставляйте комментарии

http://ru.stackoverflow.com/questions/667/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BC%D0%BE%D0%B4%D1%83%D0%BB%D1%8F-%D1%87%D0%B8%D1%81%D0%BB%D0%B0-%D0%B1%D0%B5%D0%B7-%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B8-%D1%81%D1%80%D0%B0%D0%B2%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {

        x |= (x >>  1);
        x |= (x >>  2);
        x |= (x >>  4);
        x |= (x >>  8);
        x |= (x >> 16);
        return x ^ (x >> 1);

        //description
        //have some number in binary     00010101101101010101
        //by this x |= (x >> 1,2,4,8,16) 00011111111111111111
        //x >>> 1  or x >> 1             00001111111111111111
        // x ^ x >>> 1                   00010000000000000000
    }
}
