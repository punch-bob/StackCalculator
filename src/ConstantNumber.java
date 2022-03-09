package src;

public class ConstantNumber 
{
    private Double number;

    public ConstantNumber(String str)
    {
        try 
        {
            this.number = Double.parseDouble(str);
        }
        catch (NumberFormatException e)
        {
            throw e;
        }
        catch (NullPointerException e)
        {
            throw e;
        }
    }

    public Double getNumber()
    {
        return this.number;
    }
}
