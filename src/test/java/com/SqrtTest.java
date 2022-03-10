package com;

import org.junit.jupiter.api.Test;

import com.exception.math_exceptions.SqrtOfNegativeNumber;
import com.exception.stack_size_exception.InvalidStackSize;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTest
{
    @Test
    public void sqrtTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sqrt = factory.getOperationByName("SQRT");
        executionContext.getStack().push(4.0);
        sqrt.execute(executionContext, null);
        assertEquals(2.0, executionContext.getStack().pop());
    }

    @Test
    public void sqrtNegativeNumberTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sqrt = factory.getOperationByName("SQRT");
        executionContext.getStack().push(-4.0);
        assertThrows(SqrtOfNegativeNumber.class, () -> sqrt.execute(executionContext, null));
    }

    @Test
    public void sqrtEmptyStackTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation sqrt = factory.getOperationByName("SQRT");
        assertThrows(InvalidStackSize.class, () -> sqrt.execute(executionContext, null));
    }
}