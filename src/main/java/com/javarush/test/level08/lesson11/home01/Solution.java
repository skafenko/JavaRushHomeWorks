package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса amy.Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();


        //напишите тут ваш код. пункт
        Iterator<Cat> iterator=cats.iterator();
        int i =0;
        while(iterator.hasNext()){
            Cat cat=iterator.next();
            i++;
            if (i==1)
                iterator.remove();
        }


        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        HashSet<Cat> createCats1=new HashSet<Cat>();
        createCats1.add(new Cat());
        createCats1.add(new Cat());
        createCats1.add(new Cat());
        return createCats1;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for(Cat cat:cats){
            System.out.println(cat);
        }
    }

    // пункт 1
    public static class Cat{

        }

    }

