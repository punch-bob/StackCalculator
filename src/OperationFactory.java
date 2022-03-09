package src;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import src.operations.Operation;

public class OperationFactory 
{
    private Map<String, Operation> operationMap;
    public OperationFactory()
    {
        operationMap = new HashMap<>();
        Properties properties = new Properties();
        
        InputStream in = OperationFactory.class.getResourceAsStream("Operations.properties");
        try
        {
            properties.load(in);
        }
        catch(IOException e)
        {
            System.err.println("Error while loading properties file: " + e.getLocalizedMessage());
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
                    System.err.println("Failed to read class:" + operationName);
                }
                catch (InstantiationException | IllegalAccessException e)
                {
                    System.err.println("Failed to instantiate operation: " + operationName);
                }
                catch (Exception e)
                {
                    System.err.println(e);
                }
            }
        }
    }

    public Operation getOperationByName(String operationName)
    {
        return operationMap.get(operationName.toUpperCase());
    }
}