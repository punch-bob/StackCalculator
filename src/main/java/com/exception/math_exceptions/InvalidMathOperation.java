package com.exception.math_exceptions;

import com.exception.CalculatorException;

public class InvalidMathOperation extends CalculatorException
{
    public InvalidMathOperation(String message) 
    {
        super(message);
    }
}
