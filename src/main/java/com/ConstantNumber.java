package com;

public class ConstantNumber 
{
    private Double number;

    public ConstantNumber(String str)
    {
        this.number = Double.parseDouble(str);
    }

    public Double getNumber()
    {
        return this.number;
    }
}
