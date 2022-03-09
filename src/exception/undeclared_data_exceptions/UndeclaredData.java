package src.exception.undeclared_data_exceptions;

import src.exception.CalculatorException;

public class UndeclaredData extends CalculatorException
{
    public UndeclaredData (String message) 
    {
        super(message);
    }   
}
