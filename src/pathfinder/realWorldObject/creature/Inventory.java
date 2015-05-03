package pathfinder.realWorldObject.creature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;

/**
 * Handles creature inventory
 *
 * @author jacob
 *
 */
public class Inventory
{
    private final HashSet<RealWorldObject> contents = new HashSet<RealWorldObject>();
    private long totalWeight;
    private int strength;
    private final boolean bipedal;
    private SizeCategory size;
    private long maxLoad;
    private Load load;
    private Load previousLoad;

    /*
     * Table holding the maximum carry weights with the index of the array being strength score.
     * This array will expand when creatures of larger strength scores are encountered and store the
     * larger values in the array.
     */
    private static int[] carryWeightMaximums = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 115, 130, 150, 175, 200, 230, 260, 300, 350, 400, 460, 520, 600, 700, 800, 920, 1040,
            1200, 1400 };

    public Inventory(int strengthScore, SizeCategory size, boolean isBipedal)
    {
        strength = strengthScore;
        this.size = size;
        bipedal = isBipedal;
        previousLoad = null;
        calcMaxLoad();
        calcLoad();
    }

    /*****************************************************
     *************** Calculation Functions ***************
     *****************************************************/

    private void calcLoad()
    {
        final int loadAsInt = (int) (totalWeight / (maxLoad / 3));
        Load temp = null;
        switch (loadAsInt)
        {
            case 0:
                temp = Load.Light;
                break;
            case 1:
                temp = Load.Medium;
                break;
            case 2:
                temp = Load.Heavy;
                break;
        }

        // set the loadHasChanged flag if the load changes
        if (!temp.equals(load))
        {
            previousLoad = load;
            load = temp;
        }
        else
        {
            previousLoad = null;
        }
    }

    private void calcMaxLoad()
    {
        if (strength <= 0)
        {
            maxLoad = 0;
        }

        while (strength >= carryWeightMaximums.length)
        {
            // double the size of the carryWeightMaximums array and fill it with the calculated
            // weights
            final int[] tempArray = new int[carryWeightMaximums.length * 2];
            for (int i = 0; i < tempArray.length; i++)
            {
                if (i < carryWeightMaximums.length)
                {
                    tempArray[i] = carryWeightMaximums[i];
                }
                else
                {
                    /*
                     * from d20pfsrd http://www.d20pfsrd.com/alignment-description/carrying-capacity
                     *
                     * Tremendous Strength: For Strength scores not shown on Table: Carrying
                     * Capacity, find the Strength score between 20 and 29 that has the same number
                     * in the “ones” digit as the creature's Strength score does and multiply the
                     * numbers in that row by 4 for every 10 points the creature's Strength is above
                     * the score for that row.
                     */
                    tempArray[i] = (int) (carryWeightMaximums[i % 10 + 20] * Math.pow(4, i / 10 - 2));
                }
            }
            carryWeightMaximums = tempArray;
        }
        maxLoad = carryWeightMaximums[strength];

        // multiply by size multiplier
        maxLoad *= bipedal ? size.getBipedCarryCapacityMultiplier() : size.getQuadrupedCarryCapacityMultiplier();
    }

    /*****************************************************
     **************** Getters and Setters ****************
     *****************************************************/

    public void setStrength(int str)
    {
        strength = str;
        calcMaxLoad();
        calcLoad();
    }

    public int getStrength()
    {
        return strength;
    }

    public void setSize(SizeCategory size)
    {
        this.size = size;
        calcMaxLoad();
        calcLoad();
    }

    public SizeCategory getSize()
    {
        return size;
    }

    public Load getLoad()
    {
        return load;
    }

    public long getTotalWeight()
    {
        return totalWeight;
    }

    /**
     * Whether or not the load changed the last time it was calculated such as changing the
     * strength, size, or items.
     *
     * @return The previous load if it has changed or null if it has not changed.
     */
    public Load previousLoad()
    {
        return previousLoad;
    }

    /*****************************************************
     ****************** Action Functions *****************
     *****************************************************/

    /**
     * Attempts to add the item to the inventory. If the weight of the item would exceed the max
     * load, the item is not added.
     *
     * @param rwo
     * @return
     */
    public boolean addItem(final RealWorldObject rwo)
    {
        /*
         * TODO creatures being overloaded, lifting above head, dragging ...
         *
         * from http://www.d20pfsrd.com/alignment-description/carrying-capacity
         *
         * Lifting and Dragging: A character can lift as much as his maximum load over his head. A
         * character's maximum load is the highest amount of weight listed for a character's
         * Strength in the heavy load column of Table: Carrying Capacity.
         *
         * A character can lift as much as double his maximum load off the ground, but he or she can
         * only stagger around with it. While overloaded in this way, the character loses any
         * Dexterity bonus to AC and can move only 5 feet per round (as a full-round action).
         *
         * A character can generally push or drag along the ground as much as five times his maximum
         * load. Favorable conditions can double these numbers, and bad circumstances can reduce
         * them by half or more.
         */

        if (totalWeight + rwo.getWeight() > maxLoad)
        {
            return false;
        }

        contents.add(rwo);
        totalWeight += rwo.getWeight();
        calcLoad();
        return true;
    }

    public boolean removeItem(final RealWorldObject rwo)
    {
        if (contents.contains(rwo))
        {
            contents.remove(rwo);
            totalWeight -= rwo.getWeight();
            calcLoad();
            return true;
        }
        return false;
    }

    public List<RealWorldObject> viewAll()
    {
        final ArrayList<RealWorldObject> returnList = new ArrayList<RealWorldObject>(contents.size());
        contents.addAll(returnList);
        return Collections.unmodifiableList(returnList);
    }

    public boolean contains(final RealWorldObject rwo)
    {
        return contents.contains(rwo);
    }

    public void removeAll()
    {
        totalWeight = 0;
        contents.clear();
        calcLoad();
    }

}
