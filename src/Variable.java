package src;

public class Variable 
{
    private final String value;

    public Variable(String value)
    {
        if(!Character.isLetter(value.charAt(0)))
        {
            throw new IllegalArgumentException("Variable must start with a letter!\n");
        }
        else if (!value.chars().allMatch(Character::isLetterOrDigit))
        {
            throw new IllegalArgumentException("Variable must contain only numbers and letters!\n");
        }
        
        this.value = value;
    }

    public String getVar()
    {
        return value;
    }
}
