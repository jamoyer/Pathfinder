package pathfinder.characters.buffs;

import pathfinder.realWorldObject.RWOModifier;

public class CharacterBuff extends RWOModifier
{
    private final BonusTarget bonusTarget;
    private final BonusType bonusType;
    private final int value;

    public CharacterBuff(String title, String description, int duration, boolean isPermanent, BonusTarget bonusTarget,
            BonusType bonusType, int value)
    {
        super(title, description, duration, isPermanent);
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

}
