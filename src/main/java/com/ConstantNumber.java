package com;

public class ConstantNumber 
{
    private Double number;
    private String numberStr;

    public ConstantNumber(String str)
    {
        this.numberStr = str;
    }

    public Double getNumber() throws NumberFormatException, NullPointerException
    {
        if (this.number == null)
        {
            this.number = Double.parseDouble(this.numberStr);
        }
        return this.number;
    }
}
