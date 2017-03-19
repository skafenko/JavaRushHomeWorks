package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Mykhailo on 19.11.2016.
 */
public abstract class CollisionObject extends GameObject {


    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int newX = getX(), newY = getY();
        switch (direction) {
            case LEFT:
                newX -= Model.FIELD_SELL_SIZE;
                break;
            case RIGHT:
                newX += Model.FIELD_SELL_SIZE;
                break;
            case UP:
                newY -= Model.FIELD_SELL_SIZE;
                break;
            case DOWN:
                newY += Model.FIELD_SELL_SIZE;
        }
        return newX == gameObject.getX() && newY == gameObject.getY();
    }
}
