package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandfather1=new Human("Han",true,84,"Dan",null,null);
        Human grandmother1=new Human("Megge",false,81,"Dan",null,null);
        Human father=new Human("Dan",true,43,"Hill","Hound","Dean");
        Human grandfather2=new Human("Han1",true,80,"Danny",null,null);
        Human grandmother2=new Human("Megge1",false,76,"Danny",null,null);
        Human mother=new Human("Danny",false,42,"Hill","Hound","Dean");
        Human children1=new Human("Hill",false,4,null,null,null);
        Human children2=new Human("Hound",true,14,null,null,null);
        Human children3=new Human("Dean",true,18,null,null,null);
        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<Human>();
        Human(String name){
            this.name=name;
        }

        Human(String name,boolean sex,int age,String childrenName1,String childrenName2,String childrenName3){
            this.name=name;
            this.sex=sex;
            this.age=age;
            if(childrenName1!=null) {
                Human childen1 = new Human(childrenName1);
                this.children.add(childen1);
            }
            if(childrenName2!=null) {
                Human childen2 = new Human(childrenName2);
                this.children.add(childen2);
            }
            if(childrenName3!=null) {
                Human childen3 = new Human(childrenName3);
                this.children.add(childen3);
            }

    }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
