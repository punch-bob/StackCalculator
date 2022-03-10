package com.exception.argument_exceptions;

public class ArgumentsCountException extends InvalidArgument
{
    public ArgumentsCountException(String message, Throwable err) 
    {
        super("operation line, not enought arguments for operation " + message + "!", err);
    }   
}
