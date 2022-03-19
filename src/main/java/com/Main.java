package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.util.logging.Level;

public class Main
{
    
    public static void main(String[] args)
    {
        CalculatorLogger log = new CalculatorLogger();
        
        BufferedReader in = null;
        try 
        {
            CalculatorStream stream = new CalculatorStream();
            in = stream.chooseStream(args);
        } 
        catch (FileNotFoundException e) 
        {
            log.getExceptionMessage(Level.SEVERE, e);
            return;
        }
        
        Calculator calculator = new Calculator();
        calculator.calculate(in);
        
    }
}