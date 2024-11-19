package com.sparta.calculator.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private static final int OLDEST_RESULT_INDEX = 0;

    private final List<BigDecimal> resultStorage = new ArrayList<>();

    // OperatorType 에서 일치한 연산자로 연산
    // 연산 결과를 리스트에 저장하고 결과 반환
    public BigDecimal calculate(char operator, T firstNum, T secondNum) {
        OperatorType operatorType = OperatorType.from(operator);
        BigDecimal result = operatorType.calculate(firstNum, secondNum);

        this.resultStorage.add(result);
        return result;
    }

    // 전체 연산 결과 반환
    // 원본 리스트를 그대로 반환하지 않도록 복사해서 반환
    public List<BigDecimal> getResults() {
        return new ArrayList<>(this.resultStorage);
    }

    // 입력받은 값보다 큰 결과값들을 출력
    public List<BigDecimal> getResults(T inputValue) {
        return this.resultStorage.stream()
                .filter(a -> a.compareTo(OperatorType.toBigDecimal(inputValue)) > 0)
                .toList();
    }

    // 가장 먼저 저장된 데이터 삭제
    public void removeResult() {
        this.resultStorage.remove(OLDEST_RESULT_INDEX);
    }
}