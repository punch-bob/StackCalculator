package com;

import org.junit.jupiter.api.Test;

import com.exception.math_exceptions.DivisionByZero;
import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivTest 
{
    @Test
    public void divTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation div = factory.getOperationByName("/");
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        div.execute(executionContext, null);
        assertEquals(0.2, executionContext.getStack().pop());
    }

    @Test
    public void divNotEnoughArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation div = factory.getOperationByName("/");
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> div.execute(executionContext, null));        
    }

    @Test
    public void divEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation div = factory.getOperationByName("/");
        assertThrows(InvalidStackSize.class, () -> div.execute(executionContext, null));        
    }

    @Test
    public void divByZeroTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation div = factory.getOperationByName("/");
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(0.0);
        assertThrows(DivisionByZero.class, () -> div.execute(executionContext, null));        
    }
}
