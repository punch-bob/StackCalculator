package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationPop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopTest 
{
    @Test
    public void popTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPop pop = new OperationPop();
        executionContext.getStack().add(2.0);
        executionContext.getStack().add(4.0);
        pop.execute(executionContext, null);
        assertEquals(2.0, executionContext.getStack().pop());
    }   

    @Test
    public void popEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPop pop = new OperationPop();
        assertThrows(InvalidStackSize.class, () -> pop.execute(executionContext, null));        
    }
}
