package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число");
        int secondNumber = new Scanner(System.in).nextInt();
        int addition = firstNumber + secondNumber;
        System.out.println("Сумма числа "+firstNumber+" и "+secondNumber+" равна "+addition);
        int subtraction = firstNumber - secondNumber;
        System.out.println("Разность числа "+firstNumber+" и "+secondNumber+" равна "+subtraction);
        int multiplication = firstNumber * secondNumber;
        System.out.println("Произведение числа "+firstNumber+" и "+secondNumber+" равно "+multiplication);
        double division = (double)firstNumber / secondNumber;
        System.out.println("Частное числа "+firstNumber+" и "+secondNumber+" равно "+division);
    }
}