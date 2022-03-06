package src;

import java.io.*;
import java.util.*;

import src.operations.Operation;

public class OperationFactory 
{
    private Map<String, Operation> operationMap;
    public OperationFactory()
    {
        operationMap = new HashMap<>();
        Properties properties = new Properties();
        
        try
        {
            InputStream in = OperationFactory.class.getResourceAsStream("Operations.properties");
            try
            {
                properties.load(in);
            }
            catch(IOException e)
            {
                System.err.println("Error while loading stream file: " + e.getLocalizedMessage());
            }

            for(String operationName : properties.stringPropertyNames())
            {
                if (!operationMap.containsKey(operationName))
                {
                    try
                    {
                        //Class<?> newOperation = ;
                        operationMap.put(operationName, (Operation)Class.forName(properties.getProperty(operationName)).getDeclaredConstructor().newInstance());
                    }
                    catch(Exception e)
                    {
                        System.err.println("failed to read class:" + operationName);
                    }
                }
            }
        }
        catch(NullPointerException e)
        {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }

    public Operation getOperation(String operationName)
    {
        return operationMap.get(operationName);
    }
}