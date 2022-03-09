package src.operations;

import src.ConstantNumber;
import src.ExecutionContext;
import src.Variable;
import src.exception.InvalidArgument;
import src.exception.InvalidArgumentsLine;
import src.exception.InvalidNumberFormat;
import src.exception.InvalidVariableName;

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
            throw new InvalidArgumentsLine("DEFINE", e);
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
