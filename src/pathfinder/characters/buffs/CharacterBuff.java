package pathfinder.characters.buffs;

import pathfinder.realWorldObject.RWOModifier;

public class CharacterBuff extends RWOModifier implements Comparable<CharacterBuff>
{
    private final BonusTarget bonusTarget;
    private final BonusType bonusType;
    private final int value;

    public CharacterBuff(String title, String description, int duration, boolean isPermanent, long sourceId, BonusTarget bonusTarget, BonusType bonusType, int value)
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
    public boolean equals(final Object o)
    {
        if (!super.equals(o))
        {
            return false;
        }
        if (!(o instanceof CharacterBuff))
        {
            return false;
        }
        final CharacterBuff temp = (CharacterBuff) o;
        if (!bonusTarget.equals(temp.getBonusTarget()))
        {
            return false;
        }
        if (!bonusType.equals(temp.getBonusType()))
        {
            return false;
        }
        if (value != temp.getValue())
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(final CharacterBuff o)
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
