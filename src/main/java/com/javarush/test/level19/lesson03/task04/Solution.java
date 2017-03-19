package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter  implements PersonScanner{
        Scanner scanner;
        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }
        @Override
        public Person read() throws IOException {
            String allInformation = scanner.nextLine().trim();
            String[] substring = allInformation.split("\\s+");
            String firstName = substring[1];
            String lastName = substring[0];
            String middleName = substring[2];
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(substring[5]), Integer.parseInt(substring[4]) - 1, Integer.parseInt(substring[3]));
            Date birthDate = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
