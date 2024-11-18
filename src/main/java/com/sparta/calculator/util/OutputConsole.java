package com.sparta.calculator.util;

import java.math.BigDecimal;
import java.util.List;

public class OutputConsole {
    private OutputConsole() {
    }

    public static void printResult(BigDecimal result) {
        System.out.println(ConsoleMessage.RESULT + result);
    }

    public static void printStoredResults(List<BigDecimal> results) {
        if (results.isEmpty()) {
            System.out.println(ConsoleMessage.NO_SELECT_OPERATION_RESULT);
        } else {
            System.out.println(ConsoleMessage.SELECT_OPERATION_RESULT + results);
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}