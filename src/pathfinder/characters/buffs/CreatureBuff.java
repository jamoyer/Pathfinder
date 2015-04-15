package pathfinder.characters.buffs;

import pathfinder.realWorldObject.RWOModifier;

public class CreatureBuff extends RWOModifier implements Comparable<CreatureBuff>
{
    private final BonusTarget bonusTarget;
    private final BonusType bonusType;
    private final int value;

    public CreatureBuff(String title, String description, int duration, boolean isPermanent, long sourceId, BonusTarget bonusTarget, BonusType bonusType, int value)
    {
        super(title, description, duration, isPermanent, sourceId);
        this.bonusTarget = bonusTarget;
        this.bonusType = bonusType;
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public BonusTarget getBonusTarget()
    {
        return bonusTarget;
    }

    public BonusType getBonusType()
    {
        return bonusType;
    }

    @Override
    public int compareTo(final CreatureBuff o)
    {
        if (o.getValue() < value)
        {
            return 1;
        }
        else if (o.getValue() == value)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

}
