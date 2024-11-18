package com.sparta.calculator.util;

import java.math.BigDecimal;
import java.util.List;

public class OutputConsole {
    // 객체 생성을 막기 위한 private 생성자
    private OutputConsole() {
    }

    // 연산 결과를 출력하는 메소드
    public static void printResult(BigDecimal result) {
        System.out.println(ConsoleMessage.RESULT + result);
    }

    // 연산 결과 리스트를 출력하는 메소드
    // 리스트가 비었다면 결과 조회가 없다는 메세지 출력
    // 있다면 연산 결과 리스트 출력
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