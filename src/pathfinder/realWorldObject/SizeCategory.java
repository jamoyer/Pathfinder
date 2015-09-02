package pathfinder.realWorldObject;

public enum SizeCategory
{
    Fine(8, 8, .125, .25, new RWODimension(.125, .125, .125), 0, 0),
    Diminutive(4, 6, .25, .5, new RWODimension(.25, .25, .25), 0, 0),
    Tiny(2, 4, .5, .75, new RWODimension(.5, .5, .5), 0, 0),
    Small(1, 2, .75, 1, new RWODimension(1, .5, 1), 1, 1),
    Medium(0, 0, 1, 1.5, new RWODimension(1, 1, 1), 1, 1),
    Large(-1, -2, 2, 3, new RWODimension(2, 2, 2), 2, 1),
    Huge(-2, -4, 4, 6, new RWODimension(3, 3, 3), 3, 2),
    Gargantuan(-4, -6, 8, 12, new RWODimension(4, 6, 4), 4, 3),
    Colossal(-8, -8, 16, 24, new RWODimension(6, 13, 6), 6, 4);

    private final int sizeModifier;
    private final int flyModifier;
    private final int specialSizeModifier;
    private final int stealthModifier;
    private final double bipedCarryCapacityMultiplier;
    private final double quadrupedCarryCapacityMultiplier;
    private final RWODimension dimensions;
    private final int naturalReach;
    private final int longReach;

    private SizeCategory(int sizeModifier, int flyModifier, double bipedCarryCapacityMultiplier, double quadrupedCarryCapacityMultiplier, RWODimension dimensions,
            int naturalReach, int longReach)
    {
        this.sizeModifier = sizeModifier;
        this.flyModifier = flyModifier;
        this.specialSizeModifier = -1 * sizeModifier;
        this.stealthModifier = 2 * flyModifier;
        this.bipedCarryCapacityMultiplier = bipedCarryCapacityMultiplier;
        this.quadrupedCarryCapacityMultiplier = quadrupedCarryCapacityMultiplier;
        this.dimensions = dimensions;
        this.naturalReach = naturalReach;
        this.longReach = longReach;
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

    /**
     * Gets the dimensions of a creature of this size category.
     *
     * @return
     */
    public RWODimension getDimensions()
    {
        return dimensions;
    }

    /**
     * Gets the natural reach of a creature this size (long). This is a radius in number of cells.
     *
     * @return
     */
    public int getLongReach()
    {
        return longReach;
    }

    /**
     * Gets the natural reach of a creature this size (tall). This is a radius in number of cells.
     *
     * @return
     */
    public int getTallReach()
    {
        return naturalReach;
    }
}