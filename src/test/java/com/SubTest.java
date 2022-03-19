package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationSub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest 
{
    @Test
    public void subTest() throws InvalidStackSize
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationSub sub = new OperationSub();
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        sub.execute(executionContext, null);
        assertEquals(-8.0, executionContext.getStack().pop());
    }

    @Test
    public void subNotEnoughArgsTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationSub sub = new OperationSub();
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> sub.execute(executionContext, null));        
    }

    @Test
    public void subEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationSub sub = new OperationSub();
        assertThrows(InvalidStackSize.class, () -> sub.execute(executionContext, null));        
    }
}

