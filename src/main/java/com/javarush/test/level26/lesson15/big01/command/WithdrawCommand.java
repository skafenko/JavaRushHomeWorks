package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mykhailo on 07.08.2016.
 */
class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amountOfMoney = ConsoleHelper.readString();

            while (!isCorrectNumber(amountOfMoney))
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                amountOfMoney = ConsoleHelper.readString();
            }

            if (!manipulator.isAmountAvailable(Integer.parseInt(amountOfMoney)))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }


            try {
                manipulator.withdrawAmount(Integer.parseInt(amountOfMoney));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

            ConsoleHelper.writeMessage(res.getString("before"));


            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(amountOfMoney), currencyCode));
            break;
        }

    }


    private boolean isCorrectNumber(String amountOfMoney)
    {
        try {
            if (Integer.parseInt(amountOfMoney) > 0)
                return true;
        } catch (NumberFormatException ignore) {
            /*NOP*/
        }
        return false;
    }
}
