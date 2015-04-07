package pathfinder.realWorldObject;

public enum SizeCategory
{
    Fine(8, 8),
    Diminutive(4, 6),
    Tiny(2, 4),
    Small(1, 2),
    Medium(0, 0),
    Large(-1, -1),
    Huge(-2, -4),
    Gargantuan(-4, -6),
    Colossal(-8, -8);

    private int sizeModifier;
    private int flyModifier;

    // TODO add the other static information about size categories in here.

    private SizeCategory(int sizeModifier, int flyModifier)
    {
        this.sizeModifier = sizeModifier;
        this.flyModifier = flyModifier;
    }

    public int getSizeModifier()
    {
        return sizeModifier;
    }

    public int getSpecialSizeModifier()
    {
        return -1 * sizeModifier;
    }

    public int getFlyModifier()
    {
        return flyModifier;
    }

    public int getStealthModifier()
    {
        return 2 * flyModifier;
    }
}
