package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class StringTooLongException extends RuntimeException {
    public StringTooLongException(String message) {
        super(message);
    }
}

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
                } else {
                    System.out.println("Указанный путь является папкой, а не файлом.");
                }
                System.out.println("Кол-во правильно введенных путей = " + correctFileCount);
                continue;
            }

            fileNumber++;
            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + fileNumber);
            System.out.println("Кол-во правильно введенных путей = " + correctFileCount);


            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                int totalLines = 0;
                int maxLength = Integer.MIN_VALUE;
                int minLength = Integer.MAX_VALUE;
                String line;
                while ((line = reader.readLine()) != null) {
                    totalLines++;
                    int length = line.length();
                    if (length > 1024) {
                        throw new StringTooLongException(
                                "Строка длинее 1024 символов: длина = " + length);
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    if (length < minLength) {
                        minLength = length;
                    }
                }
                System.out.println("Общее количество строк в файле: " + totalLines);
                if (totalLines > 0) {
                    System.out.println("Длина самой длинной строки: " + maxLength);
                    System.out.println("Длина самой короткой строки: " + minLength);
                } else {
                    System.out.println("Файл пустой.");
                }

            } catch (StringTooLongException ex) {
                System.err.println("Ошибка: " + ex.getMessage());
               break;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}