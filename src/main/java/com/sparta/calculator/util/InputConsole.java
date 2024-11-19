package com.sparta.calculator.util;

import com.sparta.calculator.exception.ExceptionMessage;

import java.util.Scanner;

public class InputConsole {
    public static final Scanner sc = new Scanner(System.in);
    private static final String YES = "yes";
    private static final String EXIT = "exit";

    // 객체 생성을 막기 위한 private 생성자
    private InputConsole() {
    }

    // 전달받은 입력값을 판별하는 메소드
    // "."을 포함하면 double
    // 그렇지 않을 경우 int로 반환
    // parse가 실패할 경우 예외 처리 : NumberFormatException
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

    // 연산자를 입력받는 메소드
    public static char getOperator() {
        OutputConsole.printMessage(ConsoleMessage.INPUT_OPERATOR);

        return sc.next().charAt(0);
    }

    // 조회 결과를 확인할지 검사하는 메소드
    // yes를 입력받으면 조회 진행
    public static boolean confirmSelect() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_SELECT);
        return YES.equalsIgnoreCase(sc.next());
    }

    // 가장 먼저 저장된 데이터를 삭제할지 검사하는 메소드
    // yes를 입력받으면 삭제 진행
    public static boolean confirmDelete() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_DELETE);
        return YES.equalsIgnoreCase(sc.next());
    }

    // 연산을 종료할지 검사하는 메소드
    // yes를 입력받으면 종료 진행
    public static boolean confirmExit() {
        OutputConsole.printMessage(ConsoleMessage.CONFIRM_EXIT);
        return EXIT.equalsIgnoreCase(sc.next());
    }
}