package pathfinder.metaObjects;

import pathfinder.realWorldObject.SizeCategory;

public class Die
{
    private int numSides;
    private int count;
    
    public Die(int numSides, int count)
    {
        this.numSides = numSides;
        this.count = count;
    }
    
    public void setNumSides(int numSides)
    {
        this.numSides = numSides;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
    public int getNumSides()
    {
        return numSides;
    }
    
    public int getCount()
    {
        return count;
    }
    
    //TODO Make table for damage calculation
    public static Die getDieForDamage(SizeCategory sizeCategory, int damageProgressionIndex)
    {
        return new Die(1,1);
    }
}
