package src.operations;

import java.util.Stack;
import src.ExecutionContext;
import src.exception.InvalidStackSize;

public class OperationMult implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2)
        {
            throw new InvalidStackSize("MULTIPLICATION");
        }
        else
        {
            stack.push(stack.pop() * stack.pop());
        }
    }
}
