package com;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CalculatorLogger
{
    private final Logger log;

    public CalculatorLogger()
    {
        try 
        {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("./resourses/logging.properties"));
        } 
        catch (SecurityException | IOException e) 
        {
            e.printStackTrace();
        }
        
        this.log = Logger.getLogger(Logger.class.getName());
    }

    public void getExceptionMessage(Level lvl, Throwable e)
    {
        log.log(lvl, "Exception: ", e);
    }

    public void getInfoMessage(String message)
    {
        log.log(Level.INFO, "Operation performed: " + message);
    }
}
