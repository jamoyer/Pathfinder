package pathfinder.characters.skill;

import pathfinder.realWorldObject.creature.AbilityScore;

public class Survival extends Skill
{
    private static final String NAME = "Survival";
    private static final boolean CAN_USE_UNTRAINED = true;
    private static final boolean HAS_ARMOR_PENTALTY = false;
    private static final AbilityScore KEY_ABILITY = AbilityScore.Wisdom;

    public Survival()
    {
        super();
    }

    public Survival(final int ranks, final boolean isClassSkill)
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
