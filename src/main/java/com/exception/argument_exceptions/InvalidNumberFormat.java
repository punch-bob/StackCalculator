package com.exception.argument_exceptions;

public class InvalidNumberFormat extends InvalidArgument
{
    public InvalidNumberFormat(String message, Throwable err)
    {
        super("number in: " + message + " operation!", err);
    }
}
