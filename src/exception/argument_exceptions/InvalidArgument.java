package src.exception.argument_exceptions;

import src.exception.CalculatorException;

public class InvalidArgument extends CalculatorException
{
    public InvalidArgument(String message, Throwable err)
    {
        super("Incorrect format of " + message, err);
    }
}
