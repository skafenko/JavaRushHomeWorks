package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mykhailo on 20.11.2016.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        while (level > 60) {
            level -= 60;
        }

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(levels)))) {
            int x0 = Model.FIELD_SELL_SIZE / 2;
            int y0 = Model.FIELD_SELL_SIZE / 2;


            while (!reader.readLine().contains("Maze: " + level));
            reader.readLine();
            int x = Integer.parseInt(reader.readLine().split("\\s+")[2]);
            int y = Integer.parseInt(reader.readLine().split("\\s+")[2]);
            reader.readLine();
            reader.readLine();
            reader.readLine();
            for (int i = 0; i < y; i++) {
                String line = reader.readLine();
                for (int j = 0; j < x; j++)
                    switch (line.charAt(j)) {
                        case 'X':
                            walls.add(new Wall(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '@':
                            player = new Player(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE);
                            break;
                        case '*':
                            boxes.add(new Box(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '&':
                            boxes.add(new Box(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            homes.add(new Home(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '.':
                            homes.add(new Home(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                    }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}
