package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintTest 
{
    @Test
    public void printEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation print = factory.getOperationByName("PRINT");
        assertThrows(InvalidStackSize.class, () -> print.execute(executionContext, null));
    }
}
