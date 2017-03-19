package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager manager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");

        for (FileProperties file : manager.getFilesList()) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
