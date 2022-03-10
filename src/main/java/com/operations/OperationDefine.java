package com.operations;

import com.ConstantNumber;
import com.ExecutionContext;
import com.Variable;
import com.exception.argument_exceptions.InvalidArgument;
import com.exception.argument_exceptions.ArgumentsCountException;
import com.exception.argument_exceptions.InvalidNumberFormat;
import com.exception.argument_exceptions.InvalidVariableName;

public class OperationDefine implements Operation
{
    @Override
    public void execute(ExecutionContext executionContext, String[] arguments) throws InvalidArgument
    {
        try
        {
            Variable var = new Variable(arguments[1]);
            ConstantNumber numb = new ConstantNumber(arguments[2]);
            executionContext.getMap().put(var.getVar(), numb.getNumber());   
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new ArgumentsCountException("DEFINE", e);
        }
        catch (NumberFormatException e)
        {
            throw new InvalidNumberFormat("DEFINE", e);
        }
        catch (IllegalArgumentException e)
        {
            throw new InvalidVariableName("DEFINE", e);
        }
    }
}
