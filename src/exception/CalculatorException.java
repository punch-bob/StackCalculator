package src.exception;

public class CalculatorException extends Exception
{
    public CalculatorException(String message)
    {
        super(message);
    }

    public CalculatorException(String message, Throwable err)
    {
        super(message, err);
    }
}
