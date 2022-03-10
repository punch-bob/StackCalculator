package com.exception;

public class CalculatorException extends RuntimeException
{
    public CalculatorException(String message)
    {
        super(message);
    }

    public CalculatorException(String message, Throwable err)
    {
        super(message, err);
    }
}
