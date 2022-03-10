package com;

import org.junit.jupiter.api.Test;

import com.exception.argument_exceptions.ArgumentsCountException;
import com.exception.argument_exceptions.InvalidNumberFormat;
import com.exception.argument_exceptions.InvalidVariableName;
import com.operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefineTest
{
    @Test
    public void defineTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args = {"define", "a", "2.0"};
        define.execute(executionContext, args);
        assertEquals(2.0, executionContext.getMap().get("a"));
    } 

    @Test
    public void redefineTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args1 = {"define", "a", "2.0"};
        String[] args2 = {"define", "a", "4.0"};
        define.execute(executionContext, args1);
        define.execute(executionContext, args2);
        assertEquals(4.0, executionContext.getMap().get("a"));
    } 
    
    @Test
    public void defineNotEnoughArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args = {"define", "a"};
        assertThrows(ArgumentsCountException.class, () -> define.execute(executionContext, args));
    } 

    @Test
    public void defineEmptyArgsTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args = {"define"};
        assertThrows(ArgumentsCountException.class, () -> define.execute(executionContext, args));
    } 

    @Test
    public void defineIncorrectDigitTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args = {"define", "a", "2,0"};
        assertThrows(InvalidNumberFormat.class, () -> define.execute(executionContext, args));
    }

    @Test
    public void defineIncorrectVarNameTest()
    {
        OperationFactory factory = new OperationFactory();
        ExecutionContext executionContext = new ExecutionContext();
        Operation define = factory.getOperationByName("DEFINE");
        String[] args = {"define", "1a", "2.0"};
        assertThrows(InvalidVariableName.class, () -> define.execute(executionContext, args));
    }
}
