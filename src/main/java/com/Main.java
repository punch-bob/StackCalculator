package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.exception.CalculatorException;
import com.exception.undeclared_data_exceptions.UndeclaredOperation;
import com.operations.Operation;

public class Main
{
    
    public static void main(String[] args)
    {
        //config logging
        try 
        {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("./resourses/logging.properties"));
        } 
        catch (SecurityException | IOException e) 
        {
            e.printStackTrace();
        }
        Logger log = Logger.getLogger(Main.class.getName());

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
                System.err.println("Error while reading file: " + e.getLocalizedMessage());
                log.log(Level.INFO, "Exception: ", e);
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
            String comandLine = in.readLine();
            while (comandLine != null) 
            {
                try 
                {
                    String slpitedComandLine[] = comandLine.split(" ");
                    Operation operation = factory.getOperationByName(slpitedComandLine[0]);
                    if (operation != null)
                    {
                        operation.execute(executionContext, slpitedComandLine);
                    }
                    else
                    {
                        throw new UndeclaredOperation(slpitedComandLine[0]);
                    }
                }
                catch (CalculatorException | ArrayIndexOutOfBoundsException e)
                {
                    e.printStackTrace();
                    log.log(Level.INFO, "Exception: ", e);
                }
                comandLine = in.readLine();
            }
        }
        catch(IOException e)
        {
           System.err.println("Error while reading file: " + e.getLocalizedMessage());
           log.log(Level.INFO, "Exception: ", e);
        }
    }
}