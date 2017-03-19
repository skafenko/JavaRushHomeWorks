package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String friendName;
    private int friendAge;//напишите тут ваш код
    private String friendSex;
    public void initialize(String friendName)
    {
        this.friendName=friendName;
    }
    public void initialize(String friendName, int friendAge)
    {
        this.friendName=friendName;
        this.friendAge=friendAge;
    }
    public void initialize(String friendName, int friendAge, String friendSex)
    {
        this.friendName=friendName;
        this.friendAge=friendAge;
        this.friendSex=friendSex;
    }
}
