package com.sparta.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private final List<Integer> resultStorage = new ArrayList<>();

    public int calculate(char operator, int firstNum, int secondNum) {
        OperatorType operatorType = OperatorType.from(operator);
        int result = operatorType.calculate(firstNum, secondNum);

        this.resultStorage.add(result);
        return result;
    }

    public List<Integer> getResultStorage() {
        return new ArrayList<>(this.resultStorage);
    }

    public void removeResult() {
        this.resultStorage.remove(0);
    }
}