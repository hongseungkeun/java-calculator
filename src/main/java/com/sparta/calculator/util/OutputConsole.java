package com.sparta.calculator.util;

import java.util.List;

public class OutputConsole {
    private OutputConsole() {
    }

    public static void printResult(double result) {
        System.out.println(ConsoleMessageConstant.RESULT + result);
    }

    public static void printStoredResults(List<Double> results) {
        if (results.isEmpty()) {
            System.out.println(ConsoleMessageConstant.NO_SELECT_OPERATION_RESULT);
        } else {
            System.out.println(ConsoleMessageConstant.SELECT_OPERATION_RESULT + results);
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}