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
            while (operationLine != null) 
            {
                operationLine = in.readLine();
                try 
                {
                    OperationLineParser operationLineParser = new OperationLineParser();
                    String slpitedOperationLine[] = operationLineParser.parseLine(operationLine);

                    Operation operation = factory.getOperationByName(slpitedOperationLine[0]);
                    if (operation != null)
                    {
                        operation.execute(executionContext, slpitedOperationLine);
                        log.getInfoMessage(slpitedOperationLine[0]);
                    }
                    else
                    {
                        throw new UndeclaredOperation(slpitedOperationLine[0]);
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
