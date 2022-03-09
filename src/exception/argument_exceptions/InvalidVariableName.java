package src.exception.argument_exceptions;

public class InvalidVariableName extends InvalidArgument
{
    public InvalidVariableName(String message, Throwable err)
    {
        super("variable name in: " + message + " operation!", err);
    }    
}
