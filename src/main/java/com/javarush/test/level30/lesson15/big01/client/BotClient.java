package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Mykhailo on 25.09.2016.
 */
public class BotClient extends Client {


    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", new Random().nextInt(100));
    }

    public static void main(String[] args) {
        Client client = new BotClient();
        client.run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String[] split = message.split(": ");
            if (split.length == 2) {
                String nameUser = split[0];
                String text = split[1];
                Date date = Calendar.getInstance().getTime();
                String strFormat = "Информация для %s: %s";
                switch (text) {
                    case "дата":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("d.MM.YYYY").format(date)));
                        break;
                    case "день":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("d").format(date)));
                        break;
                    case "месяц":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("MMMM").format(date)));
                        break;
                    case "год":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("YYYY").format(date)));
                        break;
                    case "время":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("H:mm:ss").format(date)));
                        break;
                    case "час":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("H").format(date)));
                        break;
                    case "минуты":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("m").format(date)));
                        break;
                    case "секунды":
                        sendTextMessage(String.format(strFormat, nameUser, new SimpleDateFormat("s").format(date)));
                        break;

                }
            }

        }
    }
}

