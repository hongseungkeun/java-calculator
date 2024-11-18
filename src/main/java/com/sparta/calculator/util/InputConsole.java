package com.sparta.calculator.util;

import com.sparta.calculator.exception.ExceptionMessage;

import java.util.Scanner;

public class InputConsole {
    public static final Scanner sc = new Scanner(System.in);
    private static final String YES = "yes";
    private static final String EXIT = "exit";

    private InputConsole() {
    }

    public static Number getValidNumber(String prompt) {
        OutputConsole.printMessage(prompt);
        String input = sc.next();

        try {
            if (input.contains(".")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.INVALID_NUM);
        }
    }

    public static char getOperator() {
        OutputConsole.printMessage(ConsoleMessage.INPUT_OPERATOR);

        return sc.next().charAt(0);
    }

    public static boolean confirmSelect() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_SELECT);
        return YES.equalsIgnoreCase(sc.next());
    }

    public static boolean confirmDelete() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_DELETE);
        return YES.equalsIgnoreCase(sc.next());
    }

    public static boolean confirmExit() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_EXIT);
        return EXIT.equalsIgnoreCase(sc.next());
    }
}