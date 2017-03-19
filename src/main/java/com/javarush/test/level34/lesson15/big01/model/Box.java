package com.javarush.test.level34.lesson15.big01.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Mykhailo on 19.11.2016.
 */
public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.black);
//        graphics.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
//        graphics.drawLine(getX() - getWidth() / 2, getY() - getHeight() / 2, getX() + getWidth() / 2, getY() + getHeight() / 2);
//        graphics.drawLine(getX() + getWidth() / 2, getY() - getHeight() / 2, getX() - getWidth() / 2, getY() + getHeight() / 2);
        try {
            graphics.drawImage(ImageIO.read(Box.class.getResourceAsStream("/box.bmp")), getX() - getWidth()/ 2, getY() - getHeight()/ 2, getWidth(), getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
