package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.operations.value_objects.Variable;

public class VarObjectTest 
{
    //correct test
    @Test
    public void correctVarNameTest()
    {
        Variable var = new Variable("C0rrectN4me");
        assertEquals("C0rrectN4me", var.getVar());
    }

    //uncorrect tests
    @Test
    public void specialSymbolsInVarNameTest()
    {
        assertThrows(IllegalArgumentException.class, () -> new Variable("Uncorrect_Name"));
    }

    @Test
    public void digitFirstInVarNameTest()
    {
        assertThrows(IllegalArgumentException.class, () -> new Variable("1uncorrectName"));
    }

    @Test
    public void spaceInVarNameTest()
    {
        assertThrows(IllegalArgumentException.class, () -> new Variable("Uncorrect name"));
    }

    @Test
    public void nullVarNameTest()
    {
        assertThrows(NullPointerException.class, () -> new Variable(null));
    }
}
