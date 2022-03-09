package src.operations;

import src.*;
import src.exception.CalculatorException;

public interface Operation 
{
    void execute(ExecutionContext executionContext, String[] arguments) throws CalculatorException;
}
