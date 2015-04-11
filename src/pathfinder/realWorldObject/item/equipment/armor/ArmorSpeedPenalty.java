package pathfinder.realWorldObject.item.equipment.armor;

public enum ArmorSpeedPenalty
{
    None(0,0),
    Regular(10, 5),
    Heavy(15, 10);
    
    private int fastPenalty;
    private int slowPenalty;
    
    private ArmorSpeedPenalty(int fastPenalty, int slowPenalty)
    {
        this.fastPenalty = fastPenalty;
        this.slowPenalty = slowPenalty;
    }
    
    public int getFastPenalty()
    {
        return this.fastPenalty;
    }
    
    public int getSlowPenalty()
    {
        return this.slowPenalty;
    }
}
