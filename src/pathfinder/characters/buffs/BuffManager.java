package pathfinder.characters.buffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BuffManager
{
    private final int[] netBonuses = new int[BonusTarget.values().length];
    private final int[] untypedTotals = new int[BonusTarget.values().length];
    private final int[] dodgeTotals = new int[BonusTarget.values().length];

    // a grid of priority queued buffs, the first list is indexed by targets, the second lists are
    // indexed by types, each value in the grid is a priority queue of buffs, sorted to give the
    // highest value
    private final List<List<PriorityQueue<CharacterBuff>>> individualBonuses;

    public BuffManager()
    {
        // initializes the individualBonuses mapping so it is unchangeable in size
        final ArrayList<List<PriorityQueue<CharacterBuff>>> tempBonusMapping = new ArrayList<List<PriorityQueue<CharacterBuff>>>(BonusTarget.values().length);
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            final ArrayList<PriorityQueue<CharacterBuff>> targetBuffList = new ArrayList<PriorityQueue<CharacterBuff>>(BonusType.values().length);
            for (int j = 0; j < BonusType.values().length; j++)
            {
                // initialize to size 3 and reverse the comparator ordering so this we get the max
                // element when we poll
                targetBuffList.add(new PriorityQueue<CharacterBuff>(3, Collections.reverseOrder()));
            }
            tempBonusMapping.add(Collections.unmodifiableList(targetBuffList));
        }
        individualBonuses = Collections.unmodifiableList(tempBonusMapping);
    }

    /**
     * Adds the buff to this manager and recalculates the bonuses if necessary.
     *
     * @param buff
     */
    public void addBuff(final CharacterBuff buff)
    {
        final int targetIndex = buff.getBonusTarget().ordinal();
        final int typeIndex = buff.getBonusType().ordinal();
        final CharacterBuff previousTopBuff = individualBonuses.get(targetIndex).get(typeIndex).poll();

        // if the queue is not empty, we might need to recalculate the bonuses
        if (previousTopBuff != null)
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
    public void removeBuff(final CharacterBuff buff)
    {
        final int targetIndex = buff.getBonusTarget().ordinal();
        final int typeIndex = buff.getBonusType().ordinal();
        final CharacterBuff previousTopBuff = individualBonuses.get(targetIndex).get(typeIndex).poll();

        // if the queue is empty we don't need to do anything
        if (previousTopBuff != null)
        {
            final int previousMaxBonus = previousTopBuff.getValue();
            // remove the buff from the queue if it exists
            if (individualBonuses.get(targetIndex).get(typeIndex).remove(buff))
            {
                final int newMaxBonus = individualBonuses.get(targetIndex).get(typeIndex).poll().getValue();

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

                // if the maximum bonus has changed, update the net by subtracting the difference
                else if (previousMaxBonus > newMaxBonus)
                {
                    netBonuses[targetIndex] -= previousMaxBonus - newMaxBonus;
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