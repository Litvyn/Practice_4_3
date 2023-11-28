package Exercise2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть повідомлення: ");
        String userMessage = scanner.nextLine();

        System.out.println("Оберіть спосіб виведення повідомлення:");
        System.out.println("1. Вивести в консоль");
        System.out.println("2. Вивести в потік виведення помилок");
        System.out.println("3. Записати в файл");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                printMessage(userMessage, new ConsolePrinter());
                break;
            case 2:
                printMessage(userMessage, createErrorPrinter());
                break;
            case 3:
                printMessage(userMessage, createFilePrinter("output.txt"));
                break;
            default:
                System.out.println("Невірний вибір.");
        }

        scanner.close();

    }

    // Метод для виведення повідомлення з використанням об'єкта що реалізує інтерфейс Printable
    static void printMessage(String msg, Printable p) throws IOException {
        p.print(msg);
    }

    // Статичний метод для створення об'єкта який реалізує інтерфейс Printable для запису в потік виведення помилок
    static Printable createErrorPrinter() {
        return errorMsg -> System.err.println("Помилка: " + errorMsg);
    }

    // Статичний метод для створення об'єкта який реалізує інтерфейс Printable для запису в файл
    static Printable createFilePrinter(String fileName) {
        return new Printable() {
            @Override
            public void print(String msg) throws IOException {
                try (FileWriter writer = new FileWriter(fileName, true)) {
                    writer.write(msg + "\n");
                    System.out.println("Повідомлення успішно записано у файл");
                } catch (IOException e) {
                    System.err.println("Помилка запису у файл: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
    }

}