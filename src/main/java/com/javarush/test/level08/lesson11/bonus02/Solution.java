package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String,String> addresses = new HashMap<String,String>();
        while (true)
        {
            String country= reader.readLine();
            if (country.isEmpty()) break;
            String family = reader.readLine();

            addresses.put(country, family);
        }

        //read home number
        String countryOfFamily = reader.readLine();
        for(Map.Entry<String,String> pair:addresses.entrySet()){
            if(countryOfFamily.equals(pair.getKey())){
                System.out.println(pair.getValue());
            }
        }
    }
}
