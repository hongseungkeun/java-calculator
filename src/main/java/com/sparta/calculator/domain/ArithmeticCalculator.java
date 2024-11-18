package com.sparta.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private static final int INDEX_ZERO = 0;

    private final List<Double> resultStorage = new ArrayList<>();

    public double calculate(char operator, T firstNum, T secondNum) {
        OperatorType operatorType = OperatorType.from(operator);
        double result = operatorType.calculate(firstNum, secondNum);

        this.resultStorage.add(result);
        return result;
    }

    public List<Double> getResults() {
        return new ArrayList<>(this.resultStorage);
    }

    public List<Double> getResults(T inputValue) {
        return new ArrayList<>(this.resultStorage)
                .stream()
                .filter(a -> inputValue.doubleValue() < a)
                .toList();
    }

    public void removeResult() {
        this.resultStorage.remove(INDEX_ZERO);
    }
}