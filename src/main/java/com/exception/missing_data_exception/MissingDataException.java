package com.exception.missing_data_exception;

import com.exception.CalculatorException;

public class MissingDataException extends CalculatorException
{

    public MissingDataException(String message, Throwable err) 
    {
        super(message, err);
    }
    
}
