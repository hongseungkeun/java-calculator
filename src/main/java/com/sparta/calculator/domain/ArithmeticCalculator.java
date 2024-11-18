package com.sparta.calculator.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private static final int OLDEST_RESULT_INDEX = 0;

    private final List<BigDecimal> resultStorage = new ArrayList<>();

    public BigDecimal calculate(char operator, T firstNum, T secondNum) {
        OperatorType operatorType = OperatorType.from(operator);
        BigDecimal result = operatorType.calculate(firstNum, secondNum);

        this.resultStorage.add(result);
        return result;
    }

    public List<BigDecimal> getResults() {
        return new ArrayList<>(this.resultStorage);
    }

    public List<BigDecimal> getResults(T inputValue) {
        return this.resultStorage.stream()
                .filter(a -> a.compareTo(OperatorType.toBigDecimal(inputValue)) > 0)
                .toList();
    }

    public void removeResult() {
        this.resultStorage.remove(OLDEST_RESULT_INDEX);
    }
}