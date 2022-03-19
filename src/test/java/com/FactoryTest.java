package com;

import org.junit.jupiter.api.Test;

import com.exception.missing_data_exception.MissingDataException;
import com.operations.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;

public class FactoryTest 
{
    OperationFactory factory;

    //Correct tests
    @Test
    public void createDefineTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("DEFINE");
        assertSame(operation.getClass(), OperationDefine.class);
    }

    @Test
    public void createAddTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("+");
        assertSame(operation.getClass(), OperationAdd.class);
    }

    @Test
    public void createDivTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("/");
        assertSame(operation.getClass(), OperationDiv.class);
    }

    @Test
    public void createMultTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("*");
        assertSame(operation.getClass(), OperationMult.class);
    }

    @Test
    public void createPopTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("POP");
        assertSame(operation.getClass(), OperationPop.class);
    }

    @Test
    public void createPrintTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("Print");
        assertSame(operation.getClass(), OperationPrint.class);
    }

    @Test
    public void createPushTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("PUSH");
        assertSame(operation.getClass(), OperationPush.class);
    }

    @Test
    public void createSqrtTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("SQRT");
        assertSame(operation.getClass(), OperationSqrt.class);
    }

    @Test
    public void createSubTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("-");
        assertSame(operation.getClass(), OperationSub.class);
    }

    //Uncorrect test
    @Test
    public void createUndeclaredOperationTest() throws IOException, MissingDataException
    {
        this.factory = new OperationFactory();
        Operation operation = factory.getOperationByName("add");
        assertNull(operation);
    }
}
