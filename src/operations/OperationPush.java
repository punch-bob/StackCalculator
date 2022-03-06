package src.operations;

import java.util.Stack;
import src.ExecutionContext;

public class OperationPush implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) 
    {
        Stack<Double> stack = executionContext.getStack();
        if (executionContext.getMap().containsKey(arguments[1]))
        {
            stack.push(executionContext.getMap().get(arguments[1]));
        }
        else
        {
            try
            {
                stack.push(Double.parseDouble(arguments[1]));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Bad format of number!");
            }
        }
    }
}
