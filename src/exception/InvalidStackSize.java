package src.exception;

public class InvalidStackSize extends CalculatorException
{
    public InvalidStackSize(String message) 
    {
        super("Not enought numbers on the stack to perfome the operation: " + message);
    }
}
