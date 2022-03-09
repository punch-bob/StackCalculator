package src.operations;

import java.util.Stack;

import src.ConstantNumber;
import src.ExecutionContext;
import src.exception.InvalidNumberFormat;

public class OperationPush implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidNumberFormat 
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
                ConstantNumber numb = new ConstantNumber(arguments[1]);
                stack.push(numb.getNumber());
            }
            catch (NumberFormatException e)
            {
                throw new InvalidNumberFormat("PUSH", e);
            }
        }
    }
}
