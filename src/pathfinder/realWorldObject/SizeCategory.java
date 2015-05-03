package pathfinder.realWorldObject;

public enum SizeCategory
{
    Fine(8, 8, .125, .25),
    Diminutive(4, 6, .25, .5),
    Tiny(2, 4, .5, .75),
    Small(1, 2, .75, 1),
    Medium(0, 0, 1, 1.5),
    Large(-1, -2, 2, 3),
    Huge(-2, -4, 4, 6),
    Gargantuan(-4, -6, 8, 12),
    Colossal(-8, -8, 16, 24);

    private final int sizeModifier;
    private final int flyModifier;
    private final int specialSizeModifier;
    private final int stealthModifier;
    private final double bipedCarryCapacityMultiplier;
    private final double quadrupedCarryCapacityMultiplier;

    // TODO add the other static information about size categories in here.

    private SizeCategory(int sizeModifier, int flyModifier, double bipedCarryCapacityMultiplier, double quadrupedCarryCapacityMultiplier)
    {
        this.sizeModifier = sizeModifier;
        this.flyModifier = flyModifier;
        this.specialSizeModifier = -1 * sizeModifier;
        this.stealthModifier = 2 * flyModifier;
        this.bipedCarryCapacityMultiplier = bipedCarryCapacityMultiplier;
        this.quadrupedCarryCapacityMultiplier = quadrupedCarryCapacityMultiplier;
    }

    public int getSizeModifier()
    {
        return sizeModifier;
    }

    public int getSpecialSizeModifier()
    {
        return specialSizeModifier;
    }

    public int getFlyModifier()
    {
        return flyModifier;
    }

    public int getStealthModifier()
    {
        return stealthModifier;
    }

    public double getBipedCarryCapacityMultiplier()
    {
        return bipedCarryCapacityMultiplier;
    }

    public double getQuadrupedCarryCapacityMultiplier()
    {
        return quadrupedCarryCapacityMultiplier;
    }
}
