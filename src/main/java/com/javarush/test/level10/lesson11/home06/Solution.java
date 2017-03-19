package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import com.javarush.test.level06.lesson08.task05.StringHelper;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human {
        //напишите тут ваши переменные и конструкторы
        String firstName;
        String lastName;
        int age;
        boolean sex;
        int weight;
        int height;

        Human(String firstName) {
            this.firstName = firstName;
        }

        Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        Human(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }

        Human(String firstName, int age, boolean sex) {
            this.firstName = firstName;
            this.age = age;
            this.sex = sex;
        }

        Human(String firstName, String lastName, int age, int weight) {
            this.firstName = firstName;
            this.age = age;
            this.lastName = lastName;
            this.weight = weight;
        }

        Human(String firstName, String lastName, int age, int weight, int height) {
            this.firstName = firstName;
            this.age = age;
            this.lastName = lastName;
            this.weight = weight;
            this.height = height;
        }

        Human(int age, int weight, int height) {
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        Human(String firstName, boolean sex, int height, int weight)
        {
            this.firstName=firstName;
            this.sex=sex;
            this.weight = weight;
            this.height = height;
        }
        Human(String lastName,boolean sex)
        {
            this.lastName=lastName;
            this.sex=sex;
        }
        Human(int age,boolean sex)
        {
            this.age=age;
            this.sex=sex;
        }
    }
}
