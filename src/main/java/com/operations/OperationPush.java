package com.operations;

import java.util.Stack;

import com.ConstantNumber;
import com.ExecutionContext;
import com.exception.argument_exceptions.ArgumentsCountException;
import com.exception.undeclared_data_exceptions.UndeclaredVariable;

public class OperationPush implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws ArgumentsCountException, UndeclaredVariable 
    {
        Stack<Double> stack = executionContext.getStack();
        try
        {
            if (executionContext.getMap().containsKey(arguments[1]))
            {
                stack.push(executionContext.getMap().get(arguments[1]));
            }
            else
            {
                try
                {
                    ConstantNumber numb = new ConstantNumber(arguments[1]);
                    stack.push(numb.getNumber());
                }
                catch (NumberFormatException e)
                {
                    throw new UndeclaredVariable(arguments[1]);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArgumentsCountException("PUSH", e);
        }
    }
}
