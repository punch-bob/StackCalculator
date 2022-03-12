package com;

public class Variable 
{
    private final String value;

    public Variable(String value)
    {   
        this.value = value;
    }

    public String getVar()
    {
        if (value == null)
        {
            throw new NullPointerException("Variable missing!");
        }
        else if(!Character.isLetter(value.charAt(0)))
        {
            throw new IllegalArgumentException("Variable must start with a letter!");
        }
        else if (!value.chars().allMatch(Character::isLetterOrDigit))
        {
            throw new IllegalArgumentException("Variable must contain only numbers and letters!");
        }
        return value;
    }
}
