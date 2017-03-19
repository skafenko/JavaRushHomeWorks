package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
  private   String dogName, dogColot;
     private int dogWeight;
    public void initialize(String dogName)
    {
        this.dogName=dogName;
    }
    public void initialize(String dogName, int dogWeight)
    {
        this.dogName=dogName;
        this.dogWeight=dogWeight;
    }
    public void initialize(String dogName, int dogWeight, String dogColot)
    {
        this.dogName=dogName;
        this.dogWeight=dogWeight;
        this.dogColot=dogColot;
    }

}
