package com.sparta.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private static final int OLDEST_RESULT_INDEX = 0;

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
        return this.resultStorage.stream()
                .filter(a -> inputValue.doubleValue() < a)
                .toList();
    }

    public void removeResult() {
        this.resultStorage.remove(OLDEST_RESULT_INDEX);
    }
}