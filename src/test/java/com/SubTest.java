package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest 
{
    @Test
    public void subTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sub = factory.getOperationByName("-");
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        sub.execute(executionContext, null);
        assertEquals(-8.0, executionContext.getStack().pop());
    }

    @Test
    public void subNotEnoughArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sub = factory.getOperationByName("-");
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> sub.execute(executionContext, null));        
    }

    @Test
    public void subEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sub = factory.getOperationByName("-");
        assertThrows(InvalidStackSize.class, () -> sub.execute(executionContext, null));        
    }
}

