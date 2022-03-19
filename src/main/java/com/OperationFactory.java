package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.util.logging.Level;

import javax.imageio.IIOException;

import com.exception.missing_data_exception.MissingDataException;
import com.operations.Operation;

public class OperationFactory 
{
    private Map<String, Operation> operationMap;
    public OperationFactory() throws IIOException
    {
        CalculatorLogger log = new CalculatorLogger();

        operationMap = new HashMap<>();
        Properties properties = new Properties();
        try
        {
            InputStream in = OperationFactory.class.getClassLoader().getResourceAsStream("Operations.properties");
            properties.load(in);
        }
        catch (NullPointerException e)
        {
            throw new MissingDataException("Properties file not found!", e);
        }
        catch (IOException e)
        {
            throw new IIOException("Error while reading properties file", e);
        }
        

        for(String operationName : properties.stringPropertyNames())
        {
            if (!operationMap.containsKey(operationName))
            {
                try
                {
                    Class<?> operationClass = Class.forName(properties.getProperty(operationName));
                    Operation newOperation = (Operation)operationClass.getDeclaredConstructor().newInstance();
                    operationMap.put(operationName, newOperation);
                }
                catch (ClassNotFoundException e)
                {
                    log.getExceptionMessage(Level.SEVERE, e);
                }
                catch (InstantiationException | IllegalAccessException e)
                {
                    log.getExceptionMessage(Level.SEVERE, e);
                }
                catch (Exception e)
                {
                    log.getExceptionMessage(Level.SEVERE, e);
                }
            }
        }
    }

    public Operation getOperationByName(String operationName)
    {
        return operationMap.get(operationName.toUpperCase());
    }
}
