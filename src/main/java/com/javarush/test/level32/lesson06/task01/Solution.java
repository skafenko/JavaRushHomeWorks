package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu


utf-8

a - 97
z - 122

A - 65
Z - 90

0 - 48
9 - 57
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte mask = 0b000;
        int passwordLength = 8;
        int preLast = passwordLength - 2;
        int last = passwordLength - 1;
        for (int i = 0; i < passwordLength; i++) {
            int random = random(0, 3);
            if (i == preLast || i == last) {
                if ((mask & 1) == 0) {
                    random = 2;
                } else if ((mask & (1 << 1)) == 0) {
                    random = 1;
                } else if ((mask & (1 << 2)) == 0) {
                    random = 0;
                }
            }


            if (random == 0) {
                int randomLowerLetter = random(97, 123);
                mask |= 1 << 2;
                out.write(randomLowerLetter);
            } else if (random == 1) {
                int randomUpperLetter = random(65, 91);
                mask |= 1 << 1;
                out.write(randomUpperLetter);
            } else if (random == 2) {
                int randomDigit = random(48, 58);
                mask |= 1;
                out.write(randomDigit);
            }
        }
        return out;
    }

    private static int random(int from, int to) {
        double random = from + Math.random() * (to - from);
        return (int) random;
    }
}
