package com.sparta.calculator.domain;

import com.sparta.calculator.exception.BadInputException;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final char operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    OperatorType(char operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    private char getOperator() {
        return operator;
    }

    public Integer calculate(Integer a, Integer b) {
        return operation.apply(a, b);
    }

    public static OperatorType from(char operator) {
        for (OperatorType opType : values()) {
            if (opType.getOperator() == operator) {
                return opType;
            }
        }
        throw new BadInputException("+,-,*,/ 연산자만 사용 가능합니다.");
    }
}
