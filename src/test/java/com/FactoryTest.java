package com;

import org.junit.jupiter.api.Test;

import com.operations.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FactoryTest 
{
    OperationFactory factory = new OperationFactory();

    //Correct tests
    @Test
    public void createDefineTest()
    {
        Operation operation = factory.getOperationByName("DEFINE");
        assertSame(operation.getClass(), OperationDefine.class);
    }

    @Test
    public void createAddTest()
    {
        Operation operation = factory.getOperationByName("+");
        assertSame(operation.getClass(), OperationAdd.class);
    }

    @Test
    public void createDivTest()
    {
        Operation operation = factory.getOperationByName("/");
        assertSame(operation.getClass(), OperationDiv.class);
    }

    @Test
    public void createMultTest()
    {
        Operation operation = factory.getOperationByName("*");
        assertSame(operation.getClass(), OperationMult.class);
    }

    @Test
    public void createPopTest()
    {
        Operation operation = factory.getOperationByName("POP");
        assertSame(operation.getClass(), OperationPop.class);
    }

    @Test
    public void createPrintTest()
    {
        Operation operation = factory.getOperationByName("Print");
        assertSame(operation.getClass(), OperationPrint.class);
    }

    @Test
    public void createPushTest()
    {
        Operation operation = factory.getOperationByName("PUSH");
        assertSame(operation.getClass(), OperationPush.class);
    }

    @Test
    public void createSqrtTest()
    {
        Operation operation = factory.getOperationByName("SQRT");
        assertSame(operation.getClass(), OperationSqrt.class);
    }

    @Test
    public void createSubTest()
    {
        Operation operation = factory.getOperationByName("-");
        assertSame(operation.getClass(), OperationSub.class);
    }

    //Uncorrect test
    @Test
    public void createUndeclaredOperationTest()
    {
        Operation operation = factory.getOperationByName("add");
        assertNull(operation);
    }
}
