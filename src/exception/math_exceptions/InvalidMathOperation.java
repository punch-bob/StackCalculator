package src.exception.math_exceptions;

import src.exception.CalculatorException;

public class InvalidMathOperation extends CalculatorException
{
    public InvalidMathOperation(String message) 
    {
        super(message);
    }
}
