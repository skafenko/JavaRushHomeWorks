package com.javarush.test.level34.lesson15.big01.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Mykhailo on 20.11.2016.
 */
public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
//        setHeight(2);
//        setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.red);
//        graphics.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
//        graphics.fillRect(getX() - getWidth() / 4, getY(), getWidth() / 2, getHeight() / 2);
//        graphics.fillOval(getX() - getWidth() / 4, getY() - getHeight() / 4, getWidth() / 2, getHeight() / 2);
//
//        graphics.setColor(Color.black);
//        graphics.drawLine(getX(), getY(), getX(), getY());
        try {
            graphics.drawImage(ImageIO.read(Home.class.getResourceAsStream("/home.bmp")), getX() - getWidth()/ 2, getY() - getHeight()/ 2, getWidth(), getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
