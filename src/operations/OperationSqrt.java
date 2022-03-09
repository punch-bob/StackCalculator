package src.operations;

import java.util.Stack;
import src.ExecutionContext;
import src.exception.math_exceptions.SqrtOfNegativeNumber;
import src.exception.stack_size_exception.InvalidStackSize;

public class OperationSqrt implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize, SqrtOfNegativeNumber 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() == 0)
        {
            throw new InvalidStackSize("SQRT");
        }
        else
        {
            double number = stack.pop();
            if (number >= 0)
            {
                stack.push(Math.sqrt(number));
            }
            else
            {
                throw new SqrtOfNegativeNumber(String.valueOf(number));
            }
        }
    }
}
