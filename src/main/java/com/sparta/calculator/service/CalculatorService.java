package com.sparta.calculator.service;

import com.sparta.calculator.domain.Calculator;
import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.view.InputView;
import com.sparta.calculator.view.OutputView;

import java.util.InputMismatchException;

public class CalculatorService {
    private static final Calculator calculator = new Calculator();

    public static void run() {
        do {
            try {
                int firstNum = InputView.getPositiveNum("첫 번째 숫자를 입력하세요: ");
                int secondNum = InputView.getPositiveNum("두 번째 숫자를 입력하세요: ");
                char operator = InputView.getOperator();

                int result = calculator.calculate(operator, firstNum, secondNum);

                OutputView.printResult(result);
                OutputView.printStoredResults(calculator.getResultStorage());

                if (InputView.confirmDelete()) {
                    calculator.removeResult();
                }
            } catch (InputMismatchException e) {
                OutputView.printlnMessage("양의 정수만 입력해주세요");
                InputView.sc.nextLine();
            } catch (ArithmeticException e) {
                OutputView.printlnMessage("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } catch (BadInputException e) {
                OutputView.printlnMessage(e.getMessage());
            }
        } while (!InputView.confirmExit());
    }
}
