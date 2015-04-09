package pathfinder.characters.skill.knowledge;

import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.creature.AbilityScore;

public abstract class Knowledge extends Skill
{
    public static final String NAME = "Knowledge";
    public static final boolean CAN_USE_UNTRAINED = false;
    public static final boolean HAS_ARMOR_PENTALTY = false;
    public static final AbilityScore KEY_ABILITY = AbilityScore.Intelligence;

    public Knowledge()
    {
        super();
    }

    public Knowledge(final int ranks, final boolean isClassSkill)
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