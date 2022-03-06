package src.operations;

import src.ExecutionContext;

public class OperationDefine implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) 
    {
        try
        {
            executionContext.getMap().put(arguments[1], Double.parseDouble(arguments[2]));   
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("not enought arguments");
        }
    }
}
