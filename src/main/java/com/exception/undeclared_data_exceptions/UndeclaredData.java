package com.exception.undeclared_data_exceptions;

import com.exception.CalculatorException;

public class UndeclaredData extends CalculatorException
{
    public UndeclaredData (String message) 
    {
        super(message);
    }   
}
