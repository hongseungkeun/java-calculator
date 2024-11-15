package com.sparta.calculator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final Scanner sc = new Scanner(System.in);

    public static int getPositiveNum(String prompt) {
        OutputView.printMessage(prompt);

        int num = sc.nextInt();

        if (num < 0) {
            throw new InputMismatchException();
        }

        return num;
    }

    public static char getOperator() {
        OutputView.printMessage("사칙연산 기호를 입력하세요: ");

        return sc.next().charAt(0);
    }

    public static boolean confirmDelete() {
        OutputView.printMessage("가장 오래된 결과를 삭제하시겠습니까? (yes 입력 시 삭제): ");
        return "yes".equalsIgnoreCase(sc.next());
    }

    public static boolean confirmExit() {
        OutputView.printMessage("더 계산하시겠습니까? (exit 입력 시 종료): ");
        return "exit".equalsIgnoreCase(sc.next());
    }
}
