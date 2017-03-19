package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private String color;
    private int centerX,centerY,radius,wigth;
    public Circle(int centerX,int centerY,int radius)
    {
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
    }
    public Circle(int centerX,int centerY,int radius, int wigth)
    {
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.wigth=wigth;
    }
    public Circle(int centerX,int centerY,int radius, int wigth,String color)
    {
        this.centerX=centerX;
        this.centerY=centerY;
        this.radius=radius;
        this.wigth=wigth;
        this.color=color;
    }

}
