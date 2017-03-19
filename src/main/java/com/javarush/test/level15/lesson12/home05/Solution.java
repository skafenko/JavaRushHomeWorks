package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе amy.Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса amy.Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса amy.Solution.
*/

public class Solution
{
    Solution(short i) {}
    Solution(int i) {}
    Solution(long l) {}

    public Solution(Integer i) {}
    public Solution(String s) {}
    public Solution(Long l) {}

    protected Solution(byte b) {}
    protected Solution(float f) {}
    protected Solution(double d) {}

    private Solution(Boolean b) {}
    private Solution(Object o) {}
    private Solution(char ch) {}

}

