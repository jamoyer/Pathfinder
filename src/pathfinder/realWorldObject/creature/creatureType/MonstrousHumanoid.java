package pathfinder.realWorldObject.creature.creatureType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.FastBAB;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.Fly;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.Stealth;
import pathfinder.characters.skill.Survival;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.craft.Craft;

public abstract class MonstrousHumanoid extends CreatureType
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 10;
    private static final int SKILL_RANKS_PER_LEVEL = 4;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new BadSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Climb.NAME, Craft.NAME,
            Fly.NAME, Intimidate.NAME, Perception.NAME, Ride.NAME, Stealth.NAME, Survival.NAME, Swim.NAME));

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
