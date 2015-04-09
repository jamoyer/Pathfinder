package pathfinder.characters.skill;

import pathfinder.realWorldObject.creature.AbilityScore;

/**
 * Each skill will extend this class.
 * 
 * @author jacob
 *
 */
public abstract class Skill
{
    private int ranks;
    private boolean isClassSkill;

    public Skill()
    {
        this.ranks = 0;
        this.isClassSkill = false;
    }

    public Skill(final int ranks, final boolean isClassSkill)
    {
        this.ranks = ranks;
        this.isClassSkill = isClassSkill;
    }

    public final int getRanks()
    {
        return this.ranks;
    }

    public final boolean isClassSkill()
    {
        return this.isClassSkill;
    }

    public final void setClassSkill(final boolean isClassSkill)
    {
        this.isClassSkill = isClassSkill;
    }

    public final void setRanks(final int ranks)
    {
        this.ranks = ranks;
    }

    /**
     * Returns true if this skill is trained (has at least one rank).
     * 
     * @return
     */
    public final boolean isTrained()
    {
        return this.ranks >= 1;
    }

    public abstract String getName();

    public abstract boolean canUseUntrained();

    public abstract boolean hasArmorPenalty();

    public abstract AbilityScore getAbility();

}
