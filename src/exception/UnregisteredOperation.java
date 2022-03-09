package src.exception;

public class UnregisteredOperation extends CalculatorException
{
    public UnregisteredOperation(String message) 
    {
        super("The operation " + message + " wasn't found!");
    }
}
