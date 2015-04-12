package pathfinder.realWorldObject.creature;

import pathfinder.realWorldObject.creature.creatureType.CreatureType;

public class BasicCreature extends Creature
{
    private final CreatureType creatureType;

    public BasicCreature(CreatureType creatureType, AbilityScores baseStats)
    {
        super(baseStats);
        this.creatureType = creatureType;
    }

    @Override
    protected void calcBaseAttackBonus()
    {
        super.setBaseAttackBonus(creatureType.getBaseAttackBonusProgression().getBAB(creatureType.getLevel()));
    }

    @Override
    protected void calcLevel()
    {
        super.setLevel(creatureType.getLevel());
    }

    @Override
    protected void calcSizeCategory()
    {
        super.setSize(creatureType.getSizeCategory());
    }

    @Override
    protected void calcMoveSpeeds()
    {
        super.setSpeeds(creatureType.getMoveSpeeds());
    }

}
