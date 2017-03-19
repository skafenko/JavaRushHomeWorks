package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Mykhailo on 23.10.2016.
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods someInterface;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterface) {
        this.someInterface = someInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");

        method.invoke(someInterface, args);

        System.out.println(method.getName() + " out");

        return null;
    }
}