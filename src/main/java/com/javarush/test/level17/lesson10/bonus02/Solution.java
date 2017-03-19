package com.javarush.test.level17.lesson10.bonus02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 i d4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length > 0)
        {
            switch (args[0])
            {
                case "-i":
                    information(args);
                    break;
                case "-d":
                    deletePerson(args);
                    break;
                case "-u":
                    updatePerson(args);
                    break;
                case "-c":
                    addPerson(args);
                    break;
                default:
                    break;
            }
        }
    }
    private static void information(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            String sex;
            if (person.getSex() == Sex.FEMALE) sex = "ж";
            else sex = "м";
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date date = person.getBirthDay();
            System.out.println(person.getName() + " " + sex + " " + format.format(date));
        }
    }

    private static void updatePerson(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 4)
        {
            Person person1 = allPeople.get(Integer.parseInt(args[i]));
            person1.setName(args[i + 1]);
            Sex sex1 = chooseSex(args[i + 2]);
            person1.setSex(sex1);
            Date date1 = chooseDate(args[i + 3]);
            person1.setBirthDay(date1);
        }
        //information(new String[]{"-i", "0", "1"});//for checking

    }

    private static void addPerson(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 3)
        {
            Date date = chooseDate(args[i + 2]);
            Person person;
            if ("ж".equals(args[i + 1])) person = Person.createFemale(args[i], date);
            else person = Person.createMale(args[i], date);
            allPeople.add(person);
            int index = allPeople.size() - 1;
            System.out.println(index);
        }

    }
    private static Sex chooseSex(String sex)
    {
        if ("ж".equals(sex)) return Sex.FEMALE;
        else return Sex.MALE;
    }

    private static Date chooseDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return dateFormat.parse(date);
    }

    private static void deletePerson(String[] args)
    {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setBirthDay(null);
            person.setName(null);
            person.setSex(null);
        }
    }
}
