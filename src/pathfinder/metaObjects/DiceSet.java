package pathfinder.metaObjects;

import java.util.Random;

import pathfinder.realWorldObject.SizeCategory;

public class DiceSet
{
    private static final Random _random = new Random();
    private int numSides;
    private int count;

    /**
     * Creates a single die with numSides sides.
     *
     * @param numSides
     */
    public DiceSet(int numSides)
    {
        this(numSides, 1);
    }

    /**
     * Creates a set of count dice each with numSides sides.
     *
     * @param numSides
     * @param count
     */
    public DiceSet(int numSides, int count)
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

    /**
     * Rolls the set of dice and returns the total.
     *
     * @return
     */
    public int getRolledTotal()
    {
        return DiceSet.getRolledTotal(numSides, count);
    }

    /**
     * Rolls the set of dice and returns each roll as a value in an array.
     *
     * @return
     */
    public int[] getRolledSet()
    {
        return DiceSet.getRolledSet(numSides, count);
    }

    public static int[] getRolledSet(int numSides, int count)
    {
        final int[] set = new int[count];
        for (int i = 0; i < count; i++)
        {
            set[i] = _random.nextInt(numSides) + 1;
        }
        return set;
    }

    public static int getRolledTotal(int numSides, int count)
    {
        int sum = 0;
        for (int i = 0; i < count; i++)
        {
            sum += _random.nextInt(numSides);
        }

        // add count because minimum for dice is 1 but nextInt minimum is 0
        return sum + count;
    }

    // TODO Make table for damage calculation
    public static DiceSet getDieForDamage(SizeCategory sizeCategory, int damageProgressionIndex)
    {
        return new DiceSet(1, 1);
    }
}
