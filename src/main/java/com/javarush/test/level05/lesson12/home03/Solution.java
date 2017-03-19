package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

import java.util.concurrent.Callable;

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Mouse jessyMouse=new Mouse("Jessy",11,4);
        Cat tomCat =new Cat("Tom",8,12);
        Cat richCat=new Cat("Rich",9,14);
        Dog rickDog=new Dog("Rick",22,54);
        Dog annaDog=new Dog("Anna",21,39);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
public static class Cat{
        String name;
        int weight,age;
        public Cat(String name,int age,int weight)
        {
            this.name=name;
            this.age=age;
            this.weight=weight;
        }
    }
    public static class Dog{
        String name;
        int weight,height;
        public Dog(String name,int weight,int height)
        {
            this.name=name;
            this.weight=weight;
            this.height=height;
        }
    }
}
