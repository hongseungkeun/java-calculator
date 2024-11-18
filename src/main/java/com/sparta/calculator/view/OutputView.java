package com.sparta.calculator.view;

import java.util.List;

public class OutputView {
    public static void printResult(double result) {
        System.out.println("결과: " + result);
    }

    public static void printStoredResults(List<Double> results) {
        if (results.isEmpty()) {
            System.out.println("연산 결과 조회: 없음");
        } else {
            System.out.println("연산 결과 조회: " + results);
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
