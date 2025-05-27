package org.example;


import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fileNumber = 0;
        int correctFileCount = 0;
        while (true) {
            System.out.println("Введите путь к файлу:");
            String path = scanner.nextLine();
            File file = new File(path);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!exists || isDirectory) {
                if (!exists) {
                    System.out.println("Файл не существует по указанному пути.");
                    System.out.println("Кол-во правильно введенных путей = "+correctFileCount);
                } else {
                    System.out.println("Указанный путь является папкой, а не файлом.");
                    System.out.println("Кол-во правильно введенных путей = "+correctFileCount);
                }
                continue;
            }
            fileNumber++;
            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + fileNumber);
            System.out.println("Кол-во правильно введенных путей = "+correctFileCount);
        }
    }
}
