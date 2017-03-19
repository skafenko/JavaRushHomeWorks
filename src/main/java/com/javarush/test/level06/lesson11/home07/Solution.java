package com.javarush.test.level06.lesson11.home07;

import java.util.ArrayList;

/* Три статические переменных name
Создай 3 public статических переменных: String amy.Solution.name, String Cat.name, String Dog.name
*/

public class Solution
{
    public static String name=Solution.name;
    public Solution(String name){
    this.name=name;
}

    public static class Cat {
        public static String name=Cat.name;
      public   Cat(String name){
            this.name=name;
        }
    }

    public static class Dog {
        public static String name=Dog.name;
       public  Dog(String name){
            this.name=name;
        }
    }
}
