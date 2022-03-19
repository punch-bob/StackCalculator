package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationAdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTest 
{
    @Test
    public void addTest() throws InvalidStackSize
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationAdd add = new OperationAdd();
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        add.execute(executionContext, null);
        assertEquals(12.0, executionContext.getStack().pop());
    }

    @Test
    public void addNotEnoughArgsTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationAdd add = new OperationAdd();
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> add.execute(executionContext, null));        
    }

    @Test
    public void addEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationAdd add = new OperationAdd();
        assertThrows(InvalidStackSize.class, () -> add.execute(executionContext, null));        
    }
}
