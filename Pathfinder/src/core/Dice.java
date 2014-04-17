package core;

import java.util.Random;

/**
 * This class represents one or multiple dice of a given number of sides.
 * @author moyer
 *
 */
public class Dice
{
    private final int numDice;
    private final int numSides;
    private final Random random;

    /**
     * Creates one dice with "sides" number of sides.
     * @param sides
     */
    public Dice(final int sides)
    {
        this(sides, 1);
    }
    /**
     * Create a "sides" sided die.
     * @param sides
     */
    public Dice(final int sides, final int dice)
    {
        numDice = dice;
        numSides = sides;
        random = new Random();
    }
    
    /**
     * Returns the number of sides of these Dice.
     * @return
     * The number of sides of these Dice.
     */
    public int getNumSides()
    {
        return numSides;
    }
    
    /**
     * Returns the number of Dice.
     * @return
     *  The number of dice.
     */
    public int getNumDice()
    {
        return numDice;
    }
    
    /**
     * Returns the roll of a single die.
     * @return
     *  A single die roll.
     */
    public int rollOne()
    {
        return random.nextInt(numSides)+1;
    }
    
    /**
     * Simulates a roll of the Dice.
     * @return
     * The sum of all rolled dice.
     */
    public int roll()
    {
        int sum=0;
        for(int i=0;i<numDice;i++)
        {
            sum += rollOne();
        }
        return sum;
    }
    
    /**
     * Returns an array containing the results of the dice that were rolled.
     * @return
     *  An array of the dice results.
     */
    public int[] getEachRoll()
    {
        int rolls[] = new int[numDice];
        for(int i=0;i<numDice;i++){
            rolls[i] = rollOne();
        }
        return rolls;
    }
}
