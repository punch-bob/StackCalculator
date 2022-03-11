package com;

import org.junit.jupiter.api.Test;

import com.exception.math_exceptions.DivisionByZero;
import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationDiv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivTest 
{
    @Test
    public void divTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationDiv div = new OperationDiv();
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(10.0);
        div.execute(executionContext, null);
        assertEquals(0.2, executionContext.getStack().pop());
    }

    @Test
    public void divNotEnoughArgsTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationDiv div = new OperationDiv();
        executionContext.getStack().push(2.0);
        assertThrows(InvalidStackSize.class, () -> div.execute(executionContext, null));        
    }

    @Test
    public void divEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationDiv div = new OperationDiv();
        assertThrows(InvalidStackSize.class, () -> div.execute(executionContext, null));        
    }

    @Test
    public void divByZeroTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationDiv div = new OperationDiv();
        executionContext.getStack().push(2.0);
        executionContext.getStack().push(0.0);
        assertThrows(DivisionByZero.class, () -> div.execute(executionContext, null));        
    }
}
