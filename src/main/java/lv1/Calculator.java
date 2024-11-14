package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String EXIT = "exit";
        String exitCheck = "";
        int result;
        int firstNum;
        int secondNum;

        while (!exitCheck.equals(EXIT)) {
            result = 0;

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNum = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNum = sc.nextInt();

                if (firstNum < 0 || secondNum < 0) {
                    throw new InputMismatchException();
                }

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                switch (operator) {
                    case '+':
                        result = firstNum + secondNum;
                        break;

                    case '-':
                        result = firstNum - secondNum;
                        break;

                    case '*':
                        result = firstNum * secondNum;
                        break;

                    case '/':
                        result = firstNum / secondNum;
                        break;

                    default:
                        System.out.println("+,-,*,/ 연산자만 가능합니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("양의 정수만 입력해주세요");
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }

            System.out.println("결과: " + result);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitCheck = sc.next();
        }
    }
}


