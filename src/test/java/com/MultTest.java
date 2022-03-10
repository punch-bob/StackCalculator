package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultTest 
{
    @Test
    public void multTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation mult = factory.getOperationByName("*");
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        mult.execute(executionContext, null);
        assertEquals(20.0, executionContext.getStack().pop());
    }

    @Test
    public void multNotEnoughArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation mult = factory.getOperationByName("*");
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> mult.execute(executionContext, null));        
    }

    @Test
    public void multEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation mult = factory.getOperationByName("*");
        assertThrows(InvalidStackSize.class, () -> mult.execute(executionContext, null));        
    }
}
