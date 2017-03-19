package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация amy.Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса amy.Solution
2) записать в него данные  - writeObject
3) сериализовать класс amy.Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private static final long serialVersionUID = 2L;
    private final String fileName;
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("d://file2.txt");
        solution.writeObject("Solution1");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d://file1.txt"));
        out.writeObject(solution);
        out.flush();
        out.close();
        solution.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d://file1.txt"));
        Solution solutionRead = (Solution) in.readObject();
        solutionRead.writeObject("Solution2");

        in.close();
        solutionRead.close();

    }
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
