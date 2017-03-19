package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Mykhailo on 03.12.2016.
 */
public class FactoryExceprion {

    public static Throwable getException(Enum e) {
        String message = "";
        if (e != null){
            message = e.name().substring(0, 1) + e.name().substring(1).toLowerCase().replace("_", " ");
        }
        if (e instanceof ExceptionApplicationMessage) {
            return new Exception(message);
        } else if (e instanceof ExceptionDBMessage) {
            return new RuntimeException(message);
        } else if (e instanceof ExceptionUserMessage) {
            return new Error(message);
        } else {
            return new IllegalArgumentException();
        }
    }
}
