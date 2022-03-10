package com;

import org.junit.jupiter.api.Test;

import com.exception.argument_exceptions.ArgumentsCountException;
import com.exception.undeclared_data_exceptions.UndeclaredVariable;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PushTest 
{
    @Test
    public void pushNotDefineTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation push = factory.getOperationByName("PUSH");
        String[] args = {"push", "2"};
        push.execute(executionContext, args);
        assertEquals(2.0, executionContext.getStack().pop());
    }

    @Test
    public void pushWithDefineTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation push = factory.getOperationByName("PUSH");
        executionContext.getMap().put("a", 2.0);
        String[] args = {"push", "a"};
        push.execute(executionContext, args);
        assertEquals(2.0, executionContext.getStack().pop());        
    }

    @Test
    public void pushUndeclaredVarTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation push = factory.getOperationByName("PUSH");
        executionContext.getMap().put("a", 2.0);
        String[] args = {"push", "b"};
        assertThrows(UndeclaredVariable.class, () -> push.execute(executionContext, args));        
    }

    @Test
    public void pushEmptyVarTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation push = factory.getOperationByName("PUSH");
        String[] args = {"push"};
        assertThrows(ArgumentsCountException.class, () -> push.execute(executionContext, args));        
    }
}
