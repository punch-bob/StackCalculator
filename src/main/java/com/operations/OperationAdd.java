package com.operations;

import java.util.Stack;

import com.ExecutionContext;
import com.exception.stack_size_exception.InvalidStackSize;

public class OperationAdd implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidStackSize 
    {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2)
        {
            throw new InvalidStackSize("ADD");
        }
        else
        {
            stack.push(stack.pop() + stack.pop());
        }
    }
}
