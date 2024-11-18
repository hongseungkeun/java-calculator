package com.sparta.calculator.service;

import com.sparta.calculator.domain.ArithmeticCalculator;
import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.util.InputConsole;
import com.sparta.calculator.util.ConsoleMessageConstant;
import com.sparta.calculator.util.OutputConsole;

public class CalculatorService {
    private static final ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

    public static void run() {
        do {
            try {
                Number firstNum = InputConsole.getPositiveNum(ConsoleMessageConstant.INPUT_FIRST_NUM);
                Number secondNum = InputConsole.getPositiveNum(ConsoleMessageConstant.INPUT_SECOND_NUM);
                char operator = InputConsole.getOperator();

                double result = calculator.calculate(operator, firstNum, secondNum);

                OutputConsole.printResult(result);
                OutputConsole.printStoredResults(calculator.getResults());

                if (InputConsole.confirmSelect()) {
                    OutputConsole.printStoredResults(calculator.getResults(
                            InputConsole.getPositiveNum(ConsoleMessageConstant.INPUT_NUM)));
                }

                if (InputConsole.confirmDelete()) {
                    calculator.removeResult();
                }
            } catch (ArithmeticException | BadInputException | NumberFormatException e) {
                OutputConsole.printlnMessage(e.getMessage());
            }
        } while (!InputConsole.confirmExit());
    }
}