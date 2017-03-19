package com.javarush.test.level35.lesson10.bonus01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        String pathToFile = "D:\\програми\\sait\\JAVA\\плагін Intellij IDEA\\JavaRushHomeWork\\src\\main\\java\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data";
//        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses");
        Set<? extends Animal> allAnimals = getAllAnimals(pathToFile);
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Path directory = Paths.get(pathToAnimals);
        ClassLoader classLoader = getMyClassLoader(pathToAnimals);
        if (Files.isDirectory(directory)) {
            try {
                DirectoryStream.Filter<Path> filter = (entry) -> (Files.isRegularFile(entry) && entry.getFileName().toString().endsWith(".class"));

                DirectoryStream<Path> paths = Files.newDirectoryStream(directory, filter);
                for (Path path : paths) {
                    if (Files.isDirectory(path) || !path.getFileName().toString().endsWith(".class")) {
                        continue;
                    }
                    String className = path.getFileName().toString().replace(".class", "");
                    Class<?> clazz = classLoader.loadClass(className);


                    System.out.println(className);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ClassLoader getMyClassLoader(String pathToDirectory) {
        return new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    byte[] b = Files.readAllBytes(Paths.get(pathToDirectory, name + ".class"));
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }
}
