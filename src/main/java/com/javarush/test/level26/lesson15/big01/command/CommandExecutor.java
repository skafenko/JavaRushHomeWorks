package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class CommandExecutor {
    private static Map<Operation, Command> commands;

    private CommandExecutor() {
    }

    static {
        commands = new HashMap<>();
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());
        commands.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        commands.get(operation).execute();
    }
}
