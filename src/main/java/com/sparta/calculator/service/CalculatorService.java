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
                Number firstNum = InputConsole.getValidNumber(ConsoleMessage.INPUT_FIRST_NUM);
                Number secondNum = InputConsole.getValidNumber(ConsoleMessage.INPUT_SECOND_NUM);
                char operator = InputConsole.getOperator();

                BigDecimal result = calculator.calculate(operator, firstNum, secondNum);

                OutputConsole.printResult(result);
                OutputConsole.printStoredResults(calculator.getResults());

                if (InputConsole.confirmSelect()) {
                    OutputConsole.printStoredResults(calculator.getResults(
                            InputConsole.getValidNumber(ConsoleMessage.INPUT_NUM)));
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