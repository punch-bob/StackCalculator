package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopTest 
{
    @Test
    public void popTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation pop = factory.getOperationByName("POP");
        executionContext.getStack().add(2.0);
        executionContext.getStack().add(4.0);
        pop.execute(executionContext, null);
        assertEquals(2.0, executionContext.getStack().pop());
    }   

    @Test
    public void popEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation pop = factory.getOperationByName("POP");
        assertThrows(InvalidStackSize.class, () -> pop.execute(executionContext, null));        
    }
}
