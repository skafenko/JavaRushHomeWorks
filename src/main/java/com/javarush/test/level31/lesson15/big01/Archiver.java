package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;

/**
 * Created by Mykhailo on 15.10.2016.
 * <p>
 * C:\Users\Mykhailo\Desktop\arch.zip
 * C:\Users\Mykhailo\Desktop\file.txt
 */
public class Archiver {


    public static void main(String[] args) {
        Operation operation = null;

        while (operation != Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

    public static Operation askOperation() throws IOException {
        final String format = "%n\t%d - %s";
        StringBuilder menu = new StringBuilder()
                .append("Выберите операцию:")
                .append(String.format(format, Operation.CREATE.ordinal(), "упаковать файлы в архив"))
                .append(String.format(format, Operation.ADD.ordinal(), "добавить файл в архив"))
                .append(String.format(format, Operation.REMOVE.ordinal(), "удалить файл из архива"))
                .append(String.format(format, Operation.EXTRACT.ordinal(), "распаковать архив"))
                .append(String.format(format, Operation.CONTENT.ordinal(), "просмотреть содержимое архива"))
                .append(String.format(format, Operation.EXIT.ordinal(), "выход"));

        ConsoleHelper.writeMessage(menu.toString());
        int code = ConsoleHelper.readInt();
        return Operation.values()[code];
    }
}
