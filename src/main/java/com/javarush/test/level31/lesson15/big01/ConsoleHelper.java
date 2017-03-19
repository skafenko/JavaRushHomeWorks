package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = in.readLine();
        return text;
    }

    public static int readInt() throws IOException {
        String text = readString();
        return Integer.parseInt(text.trim());
    }
}
