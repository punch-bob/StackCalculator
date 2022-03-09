package src.operations;

import java.util.Stack;
import src.ExecutionContext;
import src.exception.math_exceptions.DivisionByZero;
import src.exception.stack_size_exception.InvalidStackSize;

public class OperationDiv implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize, DivisionByZero 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2)
        {
            throw new InvalidStackSize("DIVISION");
        }
        else
        {
            
            if(stack.peek() == 0)
            {
                throw new DivisionByZero("You can't divide by zero!");
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
