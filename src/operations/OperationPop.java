package src.operations;

import java.util.Stack;
import src.ExecutionContext;
import src.exception.stack_size_exception.InvalidStackSize;

public class OperationPop implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 1)
        {
            throw new InvalidStackSize("POP");
        }
        else
        {
            stack.pop();
        }
    }
}
