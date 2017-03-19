package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String catName;
    private int catWeight;
    private int catAge;
    private String catColor;
    private String catAddres;
    public void initialize(String catName)
    {
        this.catName=catName;
    }
    public void initialize(String catName, int catWeight, int catAge)
    {
        this.catName=catName;
        this.catWeight=catWeight;
        this.catAge=catAge;
    }
    public void initialize(String catName, int catAge)
    {
        this.catName=catName;
        this.catAge=catAge;
    }
    public void initialize(int catWeight, String catColor)
    {
        this.catWeight=catWeight;
        this.catColor=catColor;
    }
    public void initialize(int catWeight, String catColor, String catAddres)
    {
        this.catWeight=catWeight;
        this.catColor=catColor;
        this.catAddres=catAddres;
    }
}
