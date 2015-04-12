package pathfinder.realWorldObject.creature;

import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.metaObjects.DiceSet;
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
    protected void initMaxHealthPoints()
    {
        super.initMaxHealthPoints();
        final DiceSet dice = new DiceSet(creatureType.getHitDieType());
        super.setMaxHealthPoints(super.getMaxHealthPoints() + dice.getRolledTotal());
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
    protected void calcSaves()
    {
        super.calcSaves();
        final BaseSavingThrowSet baseSaves = creatureType.getSavingThrowSet();
        super.setReflex(super.getReflex() + baseSaves.getBaseReflex(creatureType.getLevel()));
        super.setFortitude(super.getFortitude() + baseSaves.getBaseFortitude(creatureType.getLevel()));
        super.setWill(super.getWill() + baseSaves.getBaseWill(creatureType.getLevel()));
    }

    @Override
    protected void calcMoveSpeeds()
    {
        super.setSpeeds(creatureType.getMoveSpeeds());
    }

    @Override
    protected void calcDamageReduction()
    {

    }

    @Override
    protected void calcSpellResistance()
    {

    }

}
