package com.sparta.calculator.service;

import com.sparta.calculator.domain.ArithmeticCalculator;
import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.util.InputConsole;
import com.sparta.calculator.util.ConsoleMessage;
import com.sparta.calculator.util.OutputConsole;

import java.math.BigDecimal;

public class CalculatorService {
    private static final ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

    public static void run() {
        do {
            try {
                // 숫자와 연산자를 입력 받는 변수
                Number firstNum = InputConsole.getValidNumber(ConsoleMessage.INPUT_FIRST_NUM);
                Number secondNum = InputConsole.getValidNumber(ConsoleMessage.INPUT_SECOND_NUM);
                char operator = InputConsole.getOperator();

                // 연산 진행
                BigDecimal result = calculator.calculate(operator, firstNum, secondNum);

                // 연산 결과 출력
                OutputConsole.printResult(result);
                OutputConsole.printStoredResults(calculator.getResults());

                // true 라면 조회한 연산 결과들을 출력
                if (InputConsole.confirmSelect()) {
                    OutputConsole.printStoredResults(calculator.getResults(
                            InputConsole.getValidNumber(ConsoleMessage.INPUT_NUM)));
                }

                // true 라면 가장 먼저 저장된 데이터 삭제 진행
                if (InputConsole.confirmDelete()) {
                    calculator.removeResult();
                }
            } catch (ArithmeticException | BadInputException | NumberFormatException e) {
                OutputConsole.printlnMessage(e.getMessage());
            }
        } while (!InputConsole.confirmExit()); // true 라면 연산 반복 종료
    }
}