package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator manipulator;
        if (manipulators.containsKey(currencyCode))
            manipulator =  manipulators.get(currencyCode);
        else {
            manipulator = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, manipulator);
        }

        return manipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulators.values();

    }
}
