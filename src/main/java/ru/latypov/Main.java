package ru.latypov;

import java.util.Scanner;

public class Main {

    public static String calc(String input) throws IllegalArgumentException {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный ввод: должно быть два операнда и один оператор");
        }

        int num1, num2;
        String operatorStr = parts[1];
        if (operatorStr.length() != 1 || "+-*/".indexOf(operatorStr) == -1) {
            throw new IllegalArgumentException("Некорректный оператор");
        }
        char operator = operatorStr.charAt(0);

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Операнды должны быть целыми числами от 1 до 10");
        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Операнды должны быть целыми числами от 1 до 10");
        }

        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Ошибка: деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректная операция");
        }
        return Integer.toString(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2 + 1)");
        try {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
