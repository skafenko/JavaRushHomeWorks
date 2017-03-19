package com.javarush.test.level29.lesson09.task01;

import java.math.BigDecimal;

/* Этот странный BigDecimal
Исправьте ошибку реализации, приводящую к погрешности вычисления, в методе getValue.
Сигнатуру метода не менять. Округление не использовать.
Читайте доп. статью про особенности автобоксинга.

https://sohabr.net/habr/post/201334/
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
//        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));    //work
        return BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2));                              //work
//        return new BigDecimal(v1).add(new BigDecimal(v2));                                    //dont work
    }
}
