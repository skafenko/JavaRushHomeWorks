package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final Integer median = getMedian(array);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int distansLeft = Math.abs(median - o1);
                int distansRight = Math.abs(median - o2);
                return distansLeft - distansRight;
            }
        });
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = {0, 1, 2, 3, 10, 22, 324, 342};
        array = sort(array);

        for (Integer i : array)
            System.out.println(i);
    }

    public static int getMedian(Integer[] array) {
        if (array.length % 2 == 0)
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else
            return array[array.length / 2];
    }
}
