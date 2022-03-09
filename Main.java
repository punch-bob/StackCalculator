import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import src.ExecutionContext;
import src.OperationFactory;
import src.exception.CalculatorException;
import src.exception.UnregisteredOperation;
import src.operations.Operation;

public class Main
{
    public static void main(String[] args)
    {
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
            }
        }
        else
        {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

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
                        throw new UnregisteredOperation(slpitedComandLine[0]);
                    }
                    comandLine = in.readLine();
                }
                catch (CalculatorException e)
                {
                   System.err.println(e);
                }
                
            }
        }
        catch(IOException e)
        {
           System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }
}