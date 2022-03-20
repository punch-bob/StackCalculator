package com;

public class OperationLineParser 
{
    public String[] parseLine(String operationLine) 
    {
        String[] parsedline = operationLine.split(" ");
        if (parsedline[0] == "#" || parsedline[0].charAt(0) == '#')
        {
            return null;
        }
        return parsedline;
    }
}
