package src.exception;

public class InvalidArgument extends CalculatorException
{
    public InvalidArgument(String message, Throwable err)
    {
        super("Incorrect format of " + message, err);
    }
}
