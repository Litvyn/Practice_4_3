package Exercise2;

import java.io.FileWriter;
import java.io.IOException;

public class PrintInfo {
    // Метод для друку повідомлення з використанням об'єкта що реалізує інтерфейс Printable
    static void printMessage(String msg, Printable p) throws IOException {
        p.print(msg);
    }


    // Статичний метод для створення об'єкта
    static Printable createFilePrinter(String fileName) {
        return new Printable() {
            @Override
            public void print(String msg) {
                try (FileWriter writer = new FileWriter(fileName, true)) {
                    writer.write(msg + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
