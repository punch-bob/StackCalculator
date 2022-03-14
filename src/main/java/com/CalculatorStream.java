package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class CalculatorStream 
{
    public BufferedReader chooseStream(String[] args) throws FileNotFoundException
    {
        BufferedReader in = null;
        if(args.length > 0)
        {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        }
        else
        {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        return in;
    }    
}
