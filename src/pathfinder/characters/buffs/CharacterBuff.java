package pathfinder.characters.buffs;

import pathfinder.realWorldObject.RWOModifier;

public class CharacterBuff extends RWOModifier
{
    private final BonusTarget bonusTarget;
    private final BonusType bonusType;

    public CharacterBuff(String title, String description, int duration, boolean isPermanent, BonusTarget bonusTarget,
            BonusType bonusType)
    {
        super(title, description, duration, isPermanent);
        this.bonusTarget = bonusTarget;
        this.bonusType = bonusType;
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
