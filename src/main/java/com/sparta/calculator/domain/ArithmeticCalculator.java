package com.sparta.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> resultStorage = new ArrayList<>();

    public double calculate(char operator, T firstNum, T secondNum) {
        OperatorType operatorType = OperatorType.from(operator);
        double result = operatorType.calculate(firstNum, secondNum);

        this.resultStorage.add(result);
        return result;
    }

    public List<Double> getResultStorage() {
        return new ArrayList<>(this.resultStorage);
    }

    public void removeResult() {
        this.resultStorage.remove(0);
    }
}