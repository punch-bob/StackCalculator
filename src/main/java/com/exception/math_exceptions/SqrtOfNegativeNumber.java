package com.exception.math_exceptions;

public class SqrtOfNegativeNumber extends InvalidMathOperation
{
    public SqrtOfNegativeNumber(String message) 
    {
        super("You can't take the square root of a negative number! Your number on the stack: " + message);
    }   
}
