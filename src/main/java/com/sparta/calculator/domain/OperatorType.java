package com.sparta.calculator.domain;

import com.sparta.calculator.exception.BadInputException;
import com.sparta.calculator.exception.ExceptionMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public enum OperatorType {
    // 입력받아온 연산자와 각 연산자를 매핑하고, 해당 연산에 따라 숫자를 BigDecimal로 변환 후 연산
    // 나눗셈 연산 진행 시 두 번째 숫자가 0이라면 예외 처리 : ArithmeticException
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
    // BiFunction 함수형 인터페이스를 사용해 두 숫자를 BigDecimal 타입으로 결과 반환
    private final BiFunction<Number, Number, BigDecimal> operation;

    OperatorType(char operator, BiFunction<Number, Number, BigDecimal> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    // 연산자 getter
    private char getOperator() {
        return operator;
    }

    // 값을 BigDecimal로 변환
    public static BigDecimal toBigDecimal(Number number) {
        return new BigDecimal(number.toString());
    }

    // 반복을 통해 입력받은 연산자와 일치하는 연산자를 찾아 반환
    // 없다면 예외 처리 : BadInputException
    public static OperatorType from(char operator) {
        for (OperatorType opType : values()) {
            if (opType.getOperator() == operator) {
                return opType;
            }
        }
        throw new BadInputException(ExceptionMessage.INVALID_OPERATOR);
    }

    // 해당된 연산으로
    public BigDecimal calculate(Number a, Number b) {
        return operation.apply(a, b);
    }
}