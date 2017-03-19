package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;
import com.javarush.test.level33.lesson15.big01.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Mykhailo on 13.11.2016.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Helper.generateRandomString(), null);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
                out.writeObject(entry);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
                entry = (Entry) in.readObject();
            }
            catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
