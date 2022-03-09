package src.exception.undeclared_data_exceptions;

public class UndeclaredVariable extends UndeclaredData
{
    public UndeclaredVariable(String message)
    {
        super("Variable named '" + message + "' wasn't found!");
    }
}
