import java.io.*;

import src.ExecutionContext;
import src.OperationFactory;
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
                String slpitedComandLine[] = comandLine.split(" ");
                Operation operation = factory.getOperation(slpitedComandLine[0]);
                if (operation != null)
                {
                    operation.execute(executionContext, slpitedComandLine);
                }
                else
                {
                    System.out.println("Operation wasn't found!");
                }
                comandLine = in.readLine();
            }
        }
        catch(IOException e)
        {
           System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        
    }
}