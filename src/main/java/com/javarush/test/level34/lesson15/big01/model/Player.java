package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Mykhailo on 19.11.2016.
 */
public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawOval(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());

        graphics.setColor(Color.yellow);
        graphics.fillOval(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());

        graphics.setColor(Color.red);
        graphics.fillOval(getX() - getWidth() / 4, getY() - getHeight() / 4, getWidth() / 2, getHeight() / 2);
    }
}
