package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._2, "1111");
        Number result3 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._3);
        Number result4 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._4);
        Number result5 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._5);
        Number result6 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._6);
        Number result7 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._7);
        Number result8 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        Number result9 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._9);
        Number result10 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._10);
        Number result12 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._12);
        Number result16 = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result3);    //expected 120
        System.out.println(result4);    //expected 33
        System.out.println(result5);    //expected 30
        System.out.println(result6);    //expected 23
        System.out.println(result7);    //expected 21
        System.out.println(result8);    //expected 17
        System.out.println(result9);    //expected 16
        System.out.println(result10);    //expected 15
        System.out.println(result12);    //expected 13
        System.out.println(result16);    //expected f
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        if (number == null || expectedNumerationSystem == null) {
            throw new NumberFormatException();
        }

        String digit = number.getDigit();
        if (digit.trim().startsWith("-")) {
            throw new NumberFormatException();
        }

        int intValue = number.getNumerationSystem().getNumerationSystemIntValue();
        String regex = "";
        if (intValue <= 10) {
            regex = "[0-" + (intValue - 1) +"]+";
        } else if (intValue == 12) {
            regex = "[0-9AaBb]+";
        } else if (intValue == 16) {
            regex = "[0-9A-Fa-f]+";
        }

        if (digit.matches(regex)) {
            BigInteger i = new BigInteger(digit, intValue);
            digit = i.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        } else {
            throw new NumberFormatException();
        }


         return new Number(expectedNumerationSystem, digit);
    }
}
