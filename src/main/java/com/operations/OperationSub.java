package com.operations;

import java.util.Stack;

import com.ExecutionContext;
import com.exception.stack_size_exception.InvalidStackSize;

public class OperationSub implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2)
        {
            throw new InvalidStackSize("SUBTRACT");
        }
        else
        {
            Double subtrahend = stack.pop();
            Double minuend = stack.pop();
            stack.push(minuend - subtrahend);
        }
    }
}
