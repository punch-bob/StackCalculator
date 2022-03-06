package src.operations;

import java.util.Stack;
import src.ExecutionContext;

public class OperationPrint implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() == 0)
        {
            System.out.println("stack is empty, operation can't be performed!");
        }
        else
        {
            System.out.println(stack.peek());
        }
    }
}
