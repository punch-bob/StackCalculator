package com.exception.argument_exceptions;

import com.exception.CalculatorException;

public class InvalidArgument extends CalculatorException
{
    public InvalidArgument(String message, Throwable err)
    {
        super("Incorrect format of " + message, err);
    }
}
