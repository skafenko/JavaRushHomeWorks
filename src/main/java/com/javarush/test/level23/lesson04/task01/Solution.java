package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса amy.Solution.
Для каждого экземпляра класса amy.Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        for (int i = 0; i < 2; i++)
        {
            Solution solution = new Solution();
            solution.innerClasses[0] = solution.new InnerClass();
            solution.innerClasses[1] = solution.new InnerClass();
            solutions[i] = solution;
        }

        return solutions;
    }
}
