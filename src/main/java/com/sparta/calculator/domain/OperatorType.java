package com.sparta.calculator.domain;

import com.sparta.calculator.exception.BadInputException;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> a.doubleValue() + b.doubleValue()),
    MINUS('-', (a, b) -> a.doubleValue() - b.doubleValue()),
    MULTIPLY('*', (a, b) -> a.doubleValue() * b.doubleValue()),
    DIVIDE('/', (a, b) -> {
        if (b.doubleValue() == 0.0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return a.doubleValue() / b.doubleValue();
    });

    private final char operator;
    private final BiFunction<Number, Number, Double> operation;

    OperatorType(char operator, BiFunction<Number, Number, Double> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    private char getOperator() {
        return operator;
    }

    public double calculate(Number a, Number b) {
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
