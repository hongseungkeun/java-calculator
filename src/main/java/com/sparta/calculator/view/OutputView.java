package com.sparta.calculator.view;

import java.util.List;

public class OutputView {
    public static void printResult(int result) {
        System.out.println("결과: " + result);
    }

    public static void printStoredResults(List<Integer> results) {
        System.out.println("저장된 결과들: " + results);
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
