package com.javarush.test.level20.lesson10.bonus02;

import com.javarush.test.level20.lesson10.bonus01.Rectangle;

import java.util.ArrayList;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/

//работает, но не принимает...спросить в обсуждении
public class Solution {
    public static void main(String[] args) {

        byte[][] a = new byte[][]{
                {1, 0, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 6");
    }


    public static int getRectangleCount(byte[][] a)
    {

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < a.length;i++)
        {
            Rectangle rectangle = new Rectangle(i, -1);
            for (int j = 0; j < a[i].length; j++)
            {
                while (j < a[i].length && a[i][j] == 1)
                {
                    rectangle.setEnd(j);
                    if (j == a[i].length - 1 || a[i][j + 1] == 0)
                    {
                        rectangles.add(rectangle);
                        rectangle = new Rectangle(i, -1);
                    }
                    j++;
                }

            }
        }


        int start = 0;
        int end = 0;
        Rectangle rectangle = null;

        for (int i = 0; i < rectangles.size();)
        {
            int index = i;
            rectangle = rectangles.get(i);
            start = rectangle.getStart();
            end = rectangle.getEnd();
            while (++index < rectangles.size())
            {
                Rectangle rectangle1 = rectangles.get(index);
                if (start + 1 == rectangle1.getStart() && end == rectangle1.getEnd())
                {
                    rectangles.remove(index);
                    start++;
                    index--;
                }
            }
            i++;
        }

        return rectangles.size();
    }
}
