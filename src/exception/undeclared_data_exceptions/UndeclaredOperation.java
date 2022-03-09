package src.exception.undeclared_data_exceptions;

public class UndeclaredOperation extends UndeclaredData
{
    public UndeclaredOperation(String message) 
    {
        super("The operation '" + message + "' wasn't found!");
    }
}
