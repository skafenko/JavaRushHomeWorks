package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Mykhailo on 07.08.2016.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
