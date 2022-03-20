package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;

import com.exception.CalculatorException;
import com.exception.missing_data_exception.MissingDataException;
import com.exception.undeclared_data_exceptions.UndeclaredOperation;
import com.operations.Operation;

public class Calculator 
{
    void calculate(BufferedReader in)
    {
        CalculatorLogger log = new CalculatorLogger();
        
        try
        {
            OperationFactory factory = new OperationFactory();
            ExecutionContext executionContext = new ExecutionContext();
            String operationLine = new String();
            OperationLineParser operationLineParser = new OperationLineParser();
            while (operationLine != null) 
            {
                operationLine = in.readLine();
                try 
                {
                    String splitedOperationLine[] = operationLineParser.parseLine(operationLine);
                    if (splitedOperationLine == null)
                    {
                        log.getInfoMessage("Comment: " + operationLine);
                        continue;
                    }
                    String operationName = splitedOperationLine[0];
                    Operation operation = factory.getOperationByName(operationName);
                    if (operation != null)
                    {
                        operation.execute(executionContext, splitedOperationLine);
                        log.getInfoMessage(operationName);
                    }
                    else
                    {
                        throw new UndeclaredOperation(operationName);
                    }
                }
                catch (CalculatorException | ArrayIndexOutOfBoundsException e)
                {
                    log.getExceptionMessage(Level.WARNING, e);
                }
            }
        }
        catch(IOException | MissingDataException e)
        {
            log.getExceptionMessage(Level.SEVERE, e);
        }
    }
}
