package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationMult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultTest 
{
    @Test
    public void multTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationMult mult = new OperationMult();
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        mult.execute(executionContext, null);
        assertEquals(20.0, executionContext.getStack().pop());
    }

    @Test
    public void multNotEnoughArgsTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationMult mult = new OperationMult();
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> mult.execute(executionContext, null));        
    }

    @Test
    public void multEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationMult mult = new OperationMult();
        assertThrows(InvalidStackSize.class, () -> mult.execute(executionContext, null));        
    }
}
