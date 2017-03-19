package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mykhailo on 24.09.2016.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
            try {
                map.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка отправки сообщения пользовател: " + map.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен!");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка создания серверного сокета или принимающего сокета!");
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Ошибка закрития серверного сокета!");
                }
            }
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            Connection connection = null;
            String userName = null;
            try {
                connection = new Connection(socket);
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом!");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом!");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                if (connection != null){
                    try {
                        connection.close();
                        ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто!");
                    } catch (IOException e) {
                        ConsoleHelper.writeMessage("Ошибка при закритии соединения с удаленным адресом!");
                    }
                }

            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receive = connection.receive();
                if (receive.getType() == MessageType.USER_NAME) {
                    String userName = receive.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                String name = map.getKey();
                if (name.equals(userName)) {
                    continue;
                }
                Message userAdded = new Message(MessageType.USER_ADDED, name);
                connection.send(userAdded);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    String data = userName + ": " + receive.getData();
                    Message message = new Message(MessageType.TEXT, data);
                    sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Ошибка...тип принятого сообщения не являеться текстом");
                }
            }
        }
    }
}
