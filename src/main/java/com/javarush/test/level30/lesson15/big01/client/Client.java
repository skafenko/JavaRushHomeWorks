package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Mykhailo on 24.09.2016.
 */
public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при отравки сообщения!");
            clientConnected = false;
        }

    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                while (true) {
                    this.wait();
                    if (clientConnected) {
                        ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                    } else {
                        ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                    }
                    break;
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка во время ошидания нотификации из другого потока!");
                return;
            }
        }

        while (clientConnected) {
            String text1 = ConsoleHelper.readString();
            if ("exit".equals(text1)) {
                break;
            }
            if (shouldSentTextFromConsole()) {
                sendTextMessage(text1);
            }

        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {

        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(serverAddress, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (receive.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    processIncomingMessage(receive.getData());
                } else if (receive.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(receive.getData());
                } else if (receive.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(receive.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

    }

}
