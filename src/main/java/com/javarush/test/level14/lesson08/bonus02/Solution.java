package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());

        int max = n1 > n2 ? n1 : n2;
        int min = n1 < n2 ? n1 : n2;

        while (true)
        {
            int nod = max % min;
            if (nod == 0)
            {
                System.out.println(min);
                break;
            }
            max = min;
            min = nod;
        }
    }
}
