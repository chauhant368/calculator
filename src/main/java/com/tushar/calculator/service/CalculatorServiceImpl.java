package com.tushar.calculator.service;

public class CalculatorServiceImpl implements ICalculatorService{

    @Override
    public long add(long op1, long op2){
        return op1 + op2;
    }

    @Override
    public long subtract(long op1, long op2){
        return op1 - op2;
    }

    @Override
    public long multiply(long op1, long op2){
        return op1 * op2;
    }

    @Override
    public long divide(long op1, long op2){
        if(op2==0){
            throw new IllegalArgumentException("Denominator cannot be zero for division operation");
        }
        return op1 / op2;
    }

}
