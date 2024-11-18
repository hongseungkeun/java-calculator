package com.sparta.calculator.service;

import com.sparta.calculator.domain.ArithmeticCalculator;
import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.view.InputView;
import com.sparta.calculator.view.OutputView;

public class CalculatorService {
    private static final ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

    public static void run() {
        do {
            try {
                Number firstNum = InputView.getPositiveNum("첫 번째 숫자를 입력하세요: ");
                Number secondNum = InputView.getPositiveNum("두 번째 숫자를 입력하세요: ");
                char operator = InputView.getOperator();

                double result = calculator.calculate(operator, firstNum, secondNum);

                OutputView.printResult(result);
                OutputView.printStoredResults(calculator.getResults());

                if (InputView.confirmSelect()) {
                    OutputView.printStoredResults(calculator.getResults(InputView.getPositiveNum("숫자를 입력하세요: ")));
                }

                if (InputView.confirmDelete()) {
                    calculator.removeResult();
                }
            } catch (ArithmeticException | BadInputException | NumberFormatException e) {
                OutputView.printlnMessage(e.getMessage());
            }
        } while (!InputView.confirmExit());
    }
}
