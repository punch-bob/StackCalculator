package src.operations;

import src.*;

public interface Operation 
{
    void execute(ExecutionContext executionContext, String[] arguments);
}
