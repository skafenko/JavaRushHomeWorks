package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class CashMachine {
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)  {
        Operation operation;
        Locale.setDefault(Locale.ENGLISH);
        try {
            Locale.setDefault(ConsoleHelper.chooseLocale());
            CommandExecutor.execute(Operation.LOGIN);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException ignore) {
            ConsoleHelper.printExitMessage();
        }
    }
}
