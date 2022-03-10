package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTest 
{
    @Test
    public void addTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation add = factory.getOperationByName("+");
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        add.execute(executionContext, null);
        assertEquals(12.0, executionContext.getStack().pop());
    }

    @Test
    public void addNotEnoughArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation add = factory.getOperationByName("+");
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> add.execute(executionContext, null));        
    }

    @Test
    public void addEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation add = factory.getOperationByName("+");
        assertThrows(InvalidStackSize.class, () -> add.execute(executionContext, null));        
    }
}
