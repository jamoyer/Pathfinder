package pathfinder.realWorldObject.creature.creatureType;

import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.FastBAB;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;

public abstract class Construct extends CreatureType
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 10;
    private static final int SKILL_RANKS_PER_LEVEL = 2;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

    private static final BaseSavingThrow FORTITUDE = new BadSave();
    private static final BaseSavingThrow REFLEX = new BadSave();
    private static final BaseSavingThrow WILL = new BadSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = null;

    @Override
    public int getHitDieType()
    {
        return HIT_DIE;
    }

    @Override
    public BaseAttackBonusProgression getBaseAttackBonusProgression()
    {
        return BASE_ATTACK_BONUS;
    }

    @Override
    public BaseSavingThrowSet getSavingThrowSet()
    {
        return BASE_SAVES;
    }

    @Override
    public int getSkillRanksPerLevel()
    {
        return SKILL_RANKS_PER_LEVEL;
    }

    @Override
    public List<String> getClassSkills()
    {
        return SKILLS;
    }

    /*
     * TODO class features
     */

}
