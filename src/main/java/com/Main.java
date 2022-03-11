package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.logging.Level;

import com.exception.CalculatorException;
import com.exception.undeclared_data_exceptions.UndeclaredOperation;
import com.operations.Operation;

public class Main
{
    
    public static void main(String[] args)
    {
        CalculatorLogger log = new CalculatorLogger();

        //choose stream
        BufferedReader in = null;
        if(args.length > 0)
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            }
            catch(IOException e)
            {
                log.getExceptionMessage(Level.SEVERE, e);
                System.exit(1);
            }
        }
        else
        {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        //factory working
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
        catch(IOException | NullPointerException e)
        {
            log.getExceptionMessage(Level.SEVERE, e);
        }
    }
}