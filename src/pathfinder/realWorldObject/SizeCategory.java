package pathfinder.realWorldObject;

public enum SizeCategory
{
    Fine(8, 8, .125, .25, .01, 0, 0),
    Diminutive(4, 6, .25, .5, .04, 0, 0),
    Tiny(2, 4, .5, .75, .25, 0, 0),
    Small(1, 2, .75, 1, 1, 1, 1),
    Medium(0, 0, 1, 1.5, 1, 1, 1),
    Large(-1, -2, 2, 3, 4, 2, 1),
    Huge(-2, -4, 4, 6, 9, 3, 2),
    Gargantuan(-4, -6, 8, 12, 16, 4, 3),
    Colossal(-8, -8, 16, 24, 36, 6, 4);

    private final int sizeModifier;
    private final int flyModifier;
    private final int specialSizeModifier;
    private final int stealthModifier;
    private final double bipedCarryCapacityMultiplier;
    private final double quadrupedCarryCapacityMultiplier;
    private final double spaceInCells;
    private final int naturalReach;
    private final int longReach;

    // TODO add the other static information about size categories in here.

    private SizeCategory(int sizeModifier, int flyModifier, double bipedCarryCapacityMultiplier, double quadrupedCarryCapacityMultiplier, double spaceInCells, int naturalReach,
            int longReach)
    {
        this.sizeModifier = sizeModifier;
        this.flyModifier = flyModifier;
        this.specialSizeModifier = -1 * sizeModifier;
        this.stealthModifier = 2 * flyModifier;
        this.bipedCarryCapacityMultiplier = bipedCarryCapacityMultiplier;
        this.quadrupedCarryCapacityMultiplier = quadrupedCarryCapacityMultiplier;
        this.spaceInCells = spaceInCells;
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
     * Gets the number of cells this creature takes up (2-dimensionally). Can and should be used to
     * calculate how many cells this creature takes up or how many creatures of this size can fit
     * into a cell.
     *
     * @return
     */
    public double getSpaceInCells()
    {
        return spaceInCells;
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
