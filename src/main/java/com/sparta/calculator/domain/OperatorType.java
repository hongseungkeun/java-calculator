package com.sparta.calculator.domain;

import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.exception.ExceptionMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> toBigDecimal(a).add(toBigDecimal(b))),
    MINUS('-', (a, b) -> toBigDecimal(a).subtract(toBigDecimal(b))),
    MULTIPLY('*', (a, b) -> toBigDecimal(a).multiply(toBigDecimal(b))),
    DIVIDE('/', (a, b) -> {
        if (toBigDecimal(b).compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException(ExceptionMessage.INDIVISIBLE_BY_ZERO);
        }
        return toBigDecimal(a).divide(toBigDecimal(b), 5, RoundingMode.HALF_UP);
    });

    private final char operator;
    private final BiFunction<Number, Number, BigDecimal> operation;

    OperatorType(char operator, BiFunction<Number, Number, BigDecimal> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    private char getOperator() {
        return operator;
    }

    public static BigDecimal toBigDecimal(Number number) {
        return new BigDecimal(number.toString());
    }

    public static OperatorType from(char operator) {
        for (OperatorType opType : values()) {
            if (opType.getOperator() == operator) {
                return opType;
            }
        }
        throw new BadInputException(ExceptionMessage.INVALID_OPERATOR);
    }

    public BigDecimal calculate(Number a, Number b) {
        return operation.apply(a, b);
    }
}