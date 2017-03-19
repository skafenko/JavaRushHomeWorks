package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Mykhailo on 03.12.2016.
 */
public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {
        switch (type) {
            case FEMALE:
                return new FemaleFactory();
            case MALE:
                return new MaleFactory();
            default:
                return null;
        }
    }
}
