package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConstNumbObjectTest
{
    @Test
    public void withoutPointNumbTest()
    {
        ConstantNumber numb = new ConstantNumber("2");
        assertEquals(2.0, numb.getNumber());
    }

    @Test
    public void withPointNumbTest()
    {
        ConstantNumber numb = new ConstantNumber("2.0");
        assertEquals(2.0, numb.getNumber());
    }

    @Test
    public void commaInNumbTest()
    {
        assertThrows(NumberFormatException.class, () -> new ConstantNumber("2,0"));
    }

    @Test
    public void letterToNumbTest()
    {
        assertThrows(NumberFormatException.class, () -> new ConstantNumber("a"));
    }

    @Test
    public void specialSynbToNumbTest()
    {
        assertThrows(NumberFormatException.class, () -> new ConstantNumber("!"));
    }

    @Test
    public void nullToNumbTest()
    {
        assertThrows(NullPointerException.class, () -> new ConstantNumber(null));
    }
}