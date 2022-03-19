package com;

import org.junit.jupiter.api.Test;

import com.exception.argument_exceptions.ArgumentsCountException;
import com.exception.undeclared_data_exceptions.UndeclaredVariable;
import com.operations.OperationPush;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PushTest 
{
    @Test
    public void pushNotDefineTest() throws ArgumentsCountException, UndeclaredVariable
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPush push = new OperationPush();
        String[] args = {"push", "2"};
        push.execute(executionContext, args);
        assertEquals(2.0, executionContext.getStack().pop());
    }

    @Test
    public void pushWithDefineTest() throws ArgumentsCountException, UndeclaredVariable
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPush push = new OperationPush();
        executionContext.getMap().put("a", 2.0);
        String[] args = {"push", "a"};
        push.execute(executionContext, args);
        assertEquals(2.0, executionContext.getStack().pop());        
    }

    @Test
    public void pushUndeclaredVarTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPush push = new OperationPush();
        executionContext.getMap().put("a", 2.0);
        String[] args = {"push", "b"};
        assertThrows(UndeclaredVariable.class, () -> push.execute(executionContext, args));        
    }

    @Test
    public void pushEmptyVarTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPush push = new OperationPush();
        String[] args = {"push"};
        assertThrows(ArgumentsCountException.class, () -> push.execute(executionContext, args));        
    }
}
