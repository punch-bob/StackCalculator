package src.operations;

import java.util.Stack;
import src.ExecutionContext;
import src.exception.InvalidStackSize;

public class OperationSub implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() == 0)
        {
            throw new InvalidStackSize("SUBTRACT");
        }
        else
        {
            stack.push(stack.pop() - stack.pop());
        }
    }
}
