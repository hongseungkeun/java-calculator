package com.sparta.calculator;

import com.sparta.calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.run();
    }
}
