package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Mykhailo on 07.08.2016.
 */
class LoginCommand implements Command {
    private final int lengthOfCard = 12;
    private final int lengthOfPinCode = 4;

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String card = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            while (!isValid(card, lengthOfCard) || !isValid(pinCode, lengthOfPinCode))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                card = ConsoleHelper.readString();
                pinCode = ConsoleHelper.readString();
            }

            if (validCreditCards.containsKey(card) && validCreditCards.getString(card).equals(pinCode)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), card));
                break;
            }

            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

        }
    }

    private boolean isValid(String card, int length) {
        return card.length() == length;
    }
}
