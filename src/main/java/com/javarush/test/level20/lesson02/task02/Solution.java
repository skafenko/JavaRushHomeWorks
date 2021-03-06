package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("misha");
            user1.setBirthDate(new Date());
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream stream = new PrintStream(outputStream);
            for (User user : users)
            {
                stream.println(user.getFirstName());
                stream.println(user.getLastName());
                if (user.getBirthDate() != null)
                {
                    stream.println(user.getBirthDate().getTime());
                }
                else stream.println("no");
                stream.println(user.isMale());
                if (user.getCountry() != null)
                {
                    stream.println(user.getCountry().getDisplayedName());
                }
                else stream.println("no");
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready())
            {
                User user = new User();
                String firstName = reader.readLine();
                if (!firstName.equals("null")) user.setFirstName(firstName);
                String lastName = reader.readLine();
                if (!lastName.equals("null")) user.setLastName(lastName);
                String date = reader.readLine();
                if (!date.equals("no")) user.setBirthDate(new Date(Long.parseLong(date)));
                String male = reader.readLine();
                user.setMale(Boolean.parseBoolean(male));
                String country = reader.readLine();
                if (!country.equals("no"))
                {
                    switch (country)
                    {
                        case "Other":
                            user.setCountry(User.Country.OTHER);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                    }
                }
                users.add(user);

            }
        }
    }
}
