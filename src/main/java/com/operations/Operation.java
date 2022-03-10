package com.operations;

import com.ExecutionContext;
import com.exception.CalculatorException;

public interface Operation 
{
    void execute(ExecutionContext executionContext, String[] arguments) throws CalculatorException;
}
