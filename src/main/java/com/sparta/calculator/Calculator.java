package com.sparta.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> resultStorage = new ArrayList<>();

    public int calculate(char operator, int firstNum, int secondNum) {
        int result = 0;

        switch (operator) {
            case '+' -> result = firstNum + secondNum;
            case '-' -> result = firstNum - secondNum;
            case '*' -> result = firstNum * secondNum;
            case '/' -> result = firstNum / secondNum;
            default -> System.out.println("+,-,*,/ 연산자만 가능합니다.");
        }

        resultStorage.add(result);
        return result;
    }
}