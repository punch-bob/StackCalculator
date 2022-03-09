package src.exception;

public class UndeclaredVariable extends UndeclaredRequest
{
    public UndeclaredVariable(String message)
    {
        super("Variable named '" + message + "' wasn't found!");
    }
}
