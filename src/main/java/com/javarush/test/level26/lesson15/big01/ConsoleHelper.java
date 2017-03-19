package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String command = "";
        try {
            command = reader.readLine().trim();
            if (command.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();

        } catch (IOException ignore) {
            /*NOP*/
        }
        return command;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode.matches("[a-zA-Z]{3}"))
                return currencyCode.toUpperCase();
            else
                writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String digits = readString();
            String[] twoValidDigits = digits.split("\\s+");
            if (isValidTwoDigits(twoValidDigits))
                return twoValidDigits;
            else
                writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage(String.format("1 - %s, 2 - %s, 3 - %s, 4 - %s", res.getString("operation.INFO"),
                    res.getString("operation.DEPOSIT"),
                    res.getString("operation.WITHDRAW"),
                    res.getString("operation.EXIT")));

            String command = readString();

            Operation operation = askOperationByCommand(command);
            if (operation != null)
                return operation;
            writeMessage(res.getString("invalid.data"));
        }
    }

    private static Operation askOperationByCommand(String command) {
        Operation operation = null;
        try {
            operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(command));
        } catch (Exception ignore) {
            /*NOP*/
        }
        return operation;
    }

    private static boolean isValidTwoDigits(String[] validTwoDigits) {
        try {
            if (validTwoDigits.length == 2 && Integer.parseInt(validTwoDigits[0]) > 0 && Integer.parseInt(validTwoDigits[1]) > 0)
                return true;
        } catch (Exception ignore) {
           /* NOT*/
        }
        return false;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

    public static Locale chooseLocale() throws InterruptOperationException{
        while (true) {
            writeMessage(String.format("1 - %s, 2 - %s", "ENGLISH", "Українська"));
            String command = null;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new InterruptOperationException();
            }
            if (command.equals("1")) {
                return Locale.ENGLISH;
            } else if (command.equals("2")) {
                return Locale.forLanguageTag("ua");
            }
        }
    }

}
