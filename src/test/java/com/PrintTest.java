package com;

import org.junit.jupiter.api.Test;

import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.OperationPrint;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintTest 
{
    @Test
    public void printEmptyStackTest()
    {
        ExecutionContext executionContext = new ExecutionContext();
        OperationPrint print = new OperationPrint();
        assertThrows(InvalidStackSize.class, () -> print.execute(executionContext, null));
    }
}
