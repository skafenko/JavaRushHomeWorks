package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/



public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        if (args.length > 0)
        {
            switch (args[0])
            {
                case "-i":
                    information(args);
                    break;
                case "-d":
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setBirthDay(null);
                    person.setName(null);
                    person.setSex(null);
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
        Person person = allPeople.get(Integer.parseInt(args[1]));
        String sex;
        if (person.getSex() == Sex.FEMALE) sex = "ж";
        else sex = "м";
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date = person.getBirthDay();
        System.out.println(person.getName() + " " + sex + " " + format.format(date));
    }

    private static void updatePerson(String[] args) throws ParseException {
        Person person1 = allPeople.get(Integer.parseInt(args[1]));
        person1.setName(args[2]);
        Sex sex1 = chooseSex(args[3]);
        person1.setSex(sex1);
        Date date1 = chooseDate(args[4]);
        person1.setBirthDay(date1);
    }

    private static void addPerson(String[] args) throws ParseException {
        Date date = chooseDate(args[3]);
        Person person;
        if ("ж".equals(args[2])) person = Person.createFemale(args[1], date);
        else person = Person.createMale(args[1], date);
        allPeople.add(person);
        int index = allPeople.size() - 1;
        System.out.println(index);
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

}
