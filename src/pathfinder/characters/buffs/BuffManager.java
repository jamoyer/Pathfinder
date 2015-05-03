package pathfinder.characters.buffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import pathfinder.realWorldObject.creature.DexLimiting;
import pathfinder.realWorldObject.item.equipment.armor.Armor;

public class BuffManager
{
    private final int[] netBonuses = new int[BonusTarget.values().length];
    private final int[] untypedTotals = new int[BonusTarget.values().length];
    private final int[] dodgeTotals = new int[BonusTarget.values().length];

    // a grid of priority queued buffs, the first list is indexed by targets, the second lists are
    // indexed by types, each value in the grid is a priority queue of buffs, sorted to give the
    // highest value
    private final List<List<PriorityQueue<CreatureBuff>>> individualBonuses;

    private final PriorityQueue<DexLimiting> maxDexTracker;

    public BuffManager()
    {
        // initializes the individualBonuses mapping so it is unchangeable in size
        final ArrayList<List<PriorityQueue<CreatureBuff>>> tempBonusMapping = new ArrayList<List<PriorityQueue<CreatureBuff>>>(BonusTarget.values().length);
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            final ArrayList<PriorityQueue<CreatureBuff>> targetBuffList = new ArrayList<PriorityQueue<CreatureBuff>>(BonusType.values().length);
            for (int j = 0; j < BonusType.values().length; j++)
            {
                // initialize to size 3 and reverse the comparator ordering so this we get the max
                // element when we poll
                targetBuffList.add(new PriorityQueue<CreatureBuff>(3, Collections.reverseOrder()));
            }
            tempBonusMapping.add(Collections.unmodifiableList(targetBuffList));
        }
        individualBonuses = Collections.unmodifiableList(tempBonusMapping);

        // initialize the maxDexTracker to have smallest max dex bonus on the top
        maxDexTracker = new PriorityQueue<DexLimiting>(4, new Comparator<DexLimiting>()
        {
            @Override
            public int compare(DexLimiting arg0, DexLimiting arg1)
            {
                /*
                 * We want a DexLimiting object that gives a larger bonus to be greater than those
                 * that give a smaller bonus because PriorityQueues are sorted by minimum on top.
                 */
                if (arg0.getMaxDexBonus() > arg1.getMaxDexBonus())
                {
                    return 1;
                }
                else if (arg0.getMaxDexBonus() == arg1.getMaxDexBonus())
                {
                    return 0;
                }
                return -1;
            }
        });
    }

    public void addDexLimiting(final DexLimiting dexLimiter)
    {
        maxDexTracker.add(dexLimiter);
    }

    public void removeDexLimiting(final DexLimiting dexLimiter)
    {
        maxDexTracker.remove(dexLimiter);
    }

    public void clearDexLimiting()
    {
        maxDexTracker.clear();
    }

    public int getMaxDexBonus()
    {
        final DexLimiting limit = maxDexTracker.peek();
        if (limit == null)
        {
            return Armor.UNLIMITED_DEX_BONUS;
        }
        return limit.getMaxDexBonus();
    }

    /**
     * Adds the buff to this manager and recalculates the bonuses if necessary.
     *
     * @param buff
     */
    public void addBuff(final CreatureBuff buff)
    {
        final int targetIndex = buff.getBonusTarget().ordinal();
        final int typeIndex = buff.getBonusType().ordinal();
        final CreatureBuff previousTopBuff = individualBonuses.get(targetIndex).get(typeIndex).peek();

        // if the queue is not empty, we might need to recalculate the bonuses
        if (previousTopBuff == null)
        {
            // recalculate the net for this target
            netBonuses[targetIndex] += buff.getValue();
        }
        else
        {
            final int previousMaxBonus = previousTopBuff.getValue();

            // check if the type stacks with itself
            if (buff.getBonusType().equals(BonusType.Untyped))
            {
                untypedTotals[targetIndex] += buff.getValue();
                netBonuses[targetIndex] += buff.getValue();
            }
            // check if the type stacks with itself
            else if (buff.getBonusType().equals(BonusType.Dodge))
            {
                dodgeTotals[targetIndex] += buff.getValue();
                netBonuses[targetIndex] += buff.getValue();
            }
            // if this new buff exceeds the existing buff, update the netBonus
            else if (previousMaxBonus < buff.getValue())
            {
                // recalculate the net for this target
                netBonuses[targetIndex] += buff.getValue() - previousMaxBonus;
            }
        }

        // add the buff to the appropriate queue
        individualBonuses.get(targetIndex).get(typeIndex).add(buff);
    }

    /**
     * Removes the buff from the manager if it exists and recalculates the bonuses if necessary.
     *
     * @param buff
     */
    public void removeBuff(final CreatureBuff buff)
    {
        final int targetIndex = buff.getBonusTarget().ordinal();
        final int typeIndex = buff.getBonusType().ordinal();
        final CreatureBuff previousTopBuff = individualBonuses.get(targetIndex).get(typeIndex).peek();

        // if the queue is empty we don't need to do anything
        if (previousTopBuff != null)
        {
            final int previousMaxBonus = previousTopBuff.getValue();
            // remove the buff from the queue if it exists
            if (individualBonuses.get(targetIndex).get(typeIndex).remove(buff))
            {
                final CreatureBuff newTopBuff = individualBonuses.get(targetIndex).get(typeIndex).peek();
                if (newTopBuff == null)
                {
                    netBonuses[targetIndex] -= previousMaxBonus;
                }
                else
                {
                    final int newMaxBonus = newTopBuff.getValue();

                    // check if the type stacks with itself
                    if (buff.getBonusType().equals(BonusType.Untyped))
                    {
                        untypedTotals[targetIndex] -= buff.getValue();
                        netBonuses[targetIndex] -= buff.getValue();
                    }

                    // check if the type stacks with itself
                    else if (buff.getBonusType().equals(BonusType.Dodge))
                    {
                        dodgeTotals[targetIndex] -= buff.getValue();
                        netBonuses[targetIndex] -= buff.getValue();
                    }

                    // if the maximum bonus has changed, update the net by subtracting the
                    // difference
                    else if (previousMaxBonus > newMaxBonus)
                    {
                        netBonuses[targetIndex] -= previousMaxBonus - newMaxBonus;
                    }
                }
            }
            else
            {
                // TODO what happens when the buff does not exist in the queue? nothing? a warning
                // message?
            }
        }
        else
        {
            // TODO what happens when the buff does not exist in the queue? nothing? a warning
            // message?
        }
    }

    /**
     * Returns the highest bonus for a given target.
     *
     * @param target
     * @return
     */
    public int getBonusByTarget(final BonusTarget target)
    {
        return netBonuses[target.ordinal()];
    }

}
