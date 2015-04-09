package pathfinder.characters.skill;

import pathfinder.realWorldObject.creature.AbilityScore;

public class Diplomacy extends Skill
{
    private static final String NAME = "Diplomacy";
    private static final boolean CAN_USE_UNTRAINED = true;
    private static final boolean HAS_ARMOR_PENTALTY = false;
    private static final AbilityScore KEY_ABILITY = AbilityScore.Charisma;

    public Diplomacy()
    {
        super();
    }

    public Diplomacy(final int ranks, final boolean isClassSkill)
    {
        super(ranks, isClassSkill);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public boolean canUseUntrained()
    {
        return CAN_USE_UNTRAINED;
    }

    @Override
    public boolean hasArmorPenalty()
    {
        return HAS_ARMOR_PENTALTY;
    }

    @Override
    public AbilityScore getAbility()
    {
        return KEY_ABILITY;
    }

    /*
     * TODO add the functionality of this skill when we have more stuff
     * implemented
     */

}