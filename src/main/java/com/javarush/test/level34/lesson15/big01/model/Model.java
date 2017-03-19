package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by Mykhailo on 19.11.2016.
 */
public class Model {
    public final static int FIELD_SELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 121;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src/main/java/com/javarush/test/level34/lesson15/big01/res/levels.txt"));

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        Set<Wall> walls = gameObjects.getWalls();
        for (Wall wall : walls) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        Set<Box> boxes = gameObjects.getBoxes();
        Player player = gameObjects.getPlayer();
        for (Box box : boxes) {
            if (player.isCollision(box, direction)) {
                if (checkWallCollision(box, direction))
                    return true;
                for (Box box1 : boxes) {
                    if (box1.equals(box)) {
                        continue;
                    }
                    if (box.isCollision(box1, direction)) {
                        return true;
                    }
                }
            }
        }

        for (Box box : boxes) {
            if (player.isCollision(box, direction)) {
                switch (direction) {
                    case LEFT:
                        box.move(-Model.FIELD_SELL_SIZE, 0);
                        break;
                    case RIGHT:
                        box.move(Model.FIELD_SELL_SIZE, 0);
                        break;
                    case UP:
                        box.move(0, -Model.FIELD_SELL_SIZE);
                        break;
                    case DOWN:
                        box.move(0, Model.FIELD_SELL_SIZE);
                        break;
                }
            }
        }

        return false;
    }

    public void checkCompletion() {
        Set<Home> homes = gameObjects.getHomes();
        Set<Box> boxes = gameObjects.getBoxes();
        boolean completed = false;
        for (Box box : boxes) {
            completed = false;
            for (Home home : homes) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) {
                    completed = true;
                    break;
                }
            }
            if (completed) {
                continue;
            }
            break;
        }
        if (completed) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) {
            return;
        }

        if (checkBoxCollision(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                gameObjects.getPlayer().move(-Model.FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                gameObjects.getPlayer().move(Model.FIELD_SELL_SIZE, 0);
                break;
            case UP:
                gameObjects.getPlayer().move(0, -Model.FIELD_SELL_SIZE);
                break;
            case DOWN:
                gameObjects.getPlayer().move(0, Model.FIELD_SELL_SIZE);
                break;
        }

        checkCompletion();
    }

    public GameObjects getGameObjects() {
        if (gameObjects == null) {
            restartLevel(currentLevel);
        }

        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
