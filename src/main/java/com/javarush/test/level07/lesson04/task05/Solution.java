package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] n=new int[20];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<n.length;i++)
        {
            n[i]=Integer.parseInt(reader.readLine());
        }
        int[] m=new int[10];
        int[] k=new int[10];
        for(int i=0;i<m.length;i++) {
                m[i] = n[i];
        }
        for(int i=0;i<k.length;i++){
            k[i]=n[i+10];
        }
        for(int i=0;i<k.length;i++){
        System.out.println(k[i]);
         }
    }
}
