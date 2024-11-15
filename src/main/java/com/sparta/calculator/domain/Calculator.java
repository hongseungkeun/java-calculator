package com.sparta.calculator.domain;

import com.sparta.calculator.exception.BadInputException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> resultStorage = new ArrayList<>();

    public int calculate(char operator, int firstNum, int secondNum) {
        int result;

        switch (operator) {
            case '+' -> result = firstNum + secondNum;
            case '-' -> result = firstNum - secondNum;
            case '*' -> result = firstNum * secondNum;
            case '/' -> result = firstNum / secondNum;
            default -> throw new BadInputException("+,-,*,/ 연산자만 사용 가능합니다.");
        }

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