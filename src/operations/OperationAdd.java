package src.operations;

import java.util.Stack;
import src.ExecutionContext;

public class OperationAdd implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() == 0)
        {
            System.out.println("stack is empty, operation can't be performed!");
        }
        if (stack.size() == 1)
        {
            System.out.println("not enought elements on the stack, operation can't be performed!");
        }
        else
        {
            stack.push(stack.pop() + stack.pop());
        }
    } 
}
