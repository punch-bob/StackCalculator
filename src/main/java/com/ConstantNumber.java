package com;

public class ConstantNumber 
{
    private Double number;

    public ConstantNumber(String str) throws NumberFormatException, NullPointerException
    {
        this.number = Double.parseDouble(str);
    }

    public Double getNumber()
    {
        return this.number;
    }
}
