package com.exception.stack_size_exception;

import com.exception.CalculatorException;

public class InvalidStackSize extends CalculatorException
{
    public InvalidStackSize(String message) 
    {
        super("Not enought numbers on the stack to perfome the operation: " + message);
    }
}
