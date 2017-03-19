package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, long n, String value) {
        System.out.println("with long");
        printMatrix(m, (float) n, value);
        printMatrix( (long) m, (long) n, value);
    }
    public static void printMatrix(int m, float n, String value) {
        System.out.println("with float");
        printMatrix(m, (long) n, value);
    }
    public static void printMatrix(long m, float n, String value) {
        System.out.println("with float, long");
        printMatrix(m, (float) n, value);
    }
    public static void printMatrix(short m, float n, String value) {
        System.out.println("with float, short");
        printMatrix((long) m, (float) n, value);
    }
    public static void printMatrix(char m, float n, String value) {
        System.out.println("with float, char");
        printMatrix( (short) m, (float) n, value);
    }
    public static void printMatrix(byte m, double n, String value) {
        System.out.println("with byte, double");
        printMatrix( (char) m, (float) n, value);
    }
    public static void printMatrix(char m, long n, String value) {
        System.out.println("with char, long");
        printMatrix( (byte) m, (double) n, value);
    }
    public static void printMatrix(long m, long n, String value) {
        System.out.println("with long, long");
        printMatrix( (char) m, (long) n, value);
    }
}
