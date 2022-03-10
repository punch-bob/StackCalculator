package com.operations;

import java.util.Stack;

import com.ExecutionContext;
import com.exception.stack_size_exception.InvalidStackSize;

public class OperationPrint implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 0)
        {
            throw new InvalidStackSize("PRINT");
        }
        else
        {
            System.out.println(stack.peek());
        }
    }
}
