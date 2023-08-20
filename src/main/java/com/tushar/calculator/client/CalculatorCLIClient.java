package com.tushar.calculator.client;

import com.tushar.calculator.service.CalculatorServiceImpl;
import com.tushar.calculator.service.ICalculatorService;

import java.util.Scanner;

public class CalculatorCLIClient {
    Scanner sc = new Scanner(System.in);
    ICalculatorService calculatorService;

    public CalculatorCLIClient() {
        calculatorService = new CalculatorServiceImpl();
    }

    public void calculatorExecution() {
        System.out.println("enter + to add");
        System.out.println("enter - to subtract");
        System.out.println("enter * to multiply");
        System.out.println("enter / to divide");
        System.out.println("Enter = for Final result");
        System.out.println("Enter your choice: ");
        long accumulator = 0;
        label:
        for (; ; ) {
            System.out.println("Enter your choice: ");
            int operatorChoice = -1;
            if(sc.hasNextLine()) {
                operatorChoice = sc.nextInt();
            }
            switch (operatorChoice) {
                case 0:
                    //= means final answer, break the loop to display final answer
                    break label;
                case 1:
                    accumulator = addOperation(accumulator);
                    break;
                case 2:
                    accumulator = subtractOperation(accumulator);
                    break;
                case 3:
                    accumulator = multiplyOperation(accumulator);
                    break;
                case 4:
                    accumulator = divideOperation(accumulator);
                    break;
                default:
                    displayInvalidOperationError(operatorChoice);
                    break;
            }
        }
        System.out.println("Answer is: " + accumulator);
    }

    private static void displayInvalidOperationError(int operatorChoice) {
        System.out.printf("Invalid operator entered: %d, please select from + - * and / .\n", operatorChoice);
    }

    private long divideOperation(long accumulator) {
        long operandInput = getLongOperandInput();
        if (operandInput == 0) {
            System.out.println(operandInput + "/" + accumulator + "=");
            throw new IllegalArgumentException("Denominator cannot be zero for division operation");
        } else {
            System.out.println(accumulator + "/" + operandInput + "=");
            accumulator = accumulator / operandInput;
        }
        System.out.println(accumulator);
        return accumulator;
    }

    private long multiplyOperation(long accumulator) {
        long operandInput = getLongOperandInput();
        System.out.println(operandInput + "*" + accumulator + "=");
        accumulator = calculatorService.multiply(accumulator, operandInput);
        System.out.println(accumulator);
        return accumulator;
    }

    private long subtractOperation(long accumulator) {
        long operandInput = getLongOperandInput();
        if (accumulator == 0) {
            System.out.println(operandInput + "-" + accumulator + "=");
        } else {
            System.out.println(accumulator + "-" + operandInput + "=");
        }
        accumulator = calculatorService.subtract(accumulator, operandInput);
        System.out.println(accumulator);
        return accumulator;
    }

    private long addOperation(long accumulator) {
        long operandInput = getLongOperandInput();
        System.out.println(operandInput + "+" + accumulator + "=");
        accumulator = calculatorService.add(operandInput, accumulator);
        System.out.println(accumulator);
        return accumulator;
    }

    private long getLongOperandInput() {
            System.out.println("Enter Operand:");
            return sc.nextLong();
    }
}
