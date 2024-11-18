package com.sparta.calculator.util;

import com.sparta.calculator.exception.ExceptionMessageConstant;

import java.util.Scanner;

public class InputConsole {
    public static final Scanner sc = new Scanner(System.in);
    private static final String YES = "yes";
    private static final String EXIT = "exit";

    private InputConsole() {
    }

    public static Number getPositiveNum(String prompt) {
        OutputConsole.printMessage(prompt);
        String input = sc.next();

        try {
            if (input.contains(".")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessageConstant.INVALID_NUM);
        }
    }

    public static char getOperator() {
        OutputConsole.printMessage(ConsoleMessageConstant.INPUT_OPERATOR);

        return sc.next().charAt(0);
    }

    public static boolean confirmSelect() {
        OutputConsole.printMessage(ConsoleMessageConstant.CONFIRM_SELECT);
        return YES.equalsIgnoreCase(sc.next());
    }

    public static boolean confirmDelete() {
        OutputConsole.printMessage(ConsoleMessageConstant.CONFIRM_DELETE);
        return YES.equalsIgnoreCase(sc.next());
    }

    public static boolean confirmExit() {
        OutputConsole.printMessage(ConsoleMessageConstant.CONFIRM_EXIT);
        return EXIT.equalsIgnoreCase(sc.next());
    }
}