package src.exception;

public class UndeclaredOperation extends UndeclaredRequest
{
    public UndeclaredOperation(String message) 
    {
        super("The operation '" + message + "' wasn't found!");
    }
}
