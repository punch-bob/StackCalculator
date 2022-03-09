package src.exception;

public class InvalidArgumentsLine extends InvalidArgument
{
    public InvalidArgumentsLine(String message, Throwable err) 
    {
        super("operation line, not enought arguments for operation " + message + "!", err);
    }   
}
