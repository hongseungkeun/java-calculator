package com.sparta.calculator.controller;

import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.service.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorController {
    private final Calculator cal;

    public CalculatorController() {
        this.cal = new Calculator();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        final String EXIT = "exit";
        final String CONFIRM_DELETE = "yes";
        String exitCheck = "";

        while (!exitCheck.equals(EXIT)) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int firstNum = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNum = sc.nextInt();

                if (firstNum < 0 || secondNum < 0) {
                    throw new InputMismatchException();
                }

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = cal.calculate(operator, firstNum, secondNum);
                System.out.println("결과: " + result);

                System.out.println("저장된 결과들: " + cal.getResultStorage());

                System.out.print("가장 오래된 결과를 삭제하시겠습니까? (yes 입력 시 삭제): ");
                String deleteCheck = sc.next();

                if (deleteCheck.equals(CONFIRM_DELETE)) {
                    cal.removeResult();
                }
            } catch (InputMismatchException e) {
                System.out.println("양의 정수만 입력해주세요");
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitCheck = sc.next();
        }
    }
}
