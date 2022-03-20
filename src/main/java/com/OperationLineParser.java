package com;

public class OperationLineParser 
{
    public String[] parseLine(String operationLine) 
    {
        if (operationLine.charAt(0) == '#')
        {
            return null;
        }
        return operationLine.split(" ");
    }
}
