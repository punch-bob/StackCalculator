package src.operations;

import java.util.Stack;
import src.ExecutionContext;

public class OperationDiv implements Operation
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
            
            if(stack.peek() == 0)
            {
                System.out.println("can't divide by zero");
            }
            else
            {
                Double divider = stack.pop();
                Double numerator = stack.pop();
                stack.push(numerator / divider);
            }
        }
    }
}
