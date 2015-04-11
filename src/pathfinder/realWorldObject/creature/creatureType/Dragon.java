package pathfinder.realWorldObject.creature.creatureType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.FastBAB;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Appraise;
import pathfinder.characters.skill.Bluff;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.Diplomacy;
import pathfinder.characters.skill.Fly;
import pathfinder.characters.skill.Heal;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Linguistics;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.Spellcraft;
import pathfinder.characters.skill.Stealth;
import pathfinder.characters.skill.Survival;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.UseMagicDevice;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Knowledge;

public abstract class Dragon extends CreatureType
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 12;
    private static final int SKILL_RANKS_PER_LEVEL = 6;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new GoodSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(
            FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections
            .unmodifiableList(Arrays.asList(Appraise.NAME, Bluff.NAME,
                    Climb.NAME, Craft.NAME, Diplomacy.NAME, Fly.NAME,
                    Heal.NAME, Intimidate.NAME, Knowledge.NAME,
                    Linguistics.NAME, Perception.NAME, SenseMotive.NAME,
                    Spellcraft.NAME, Stealth.NAME, Survival.NAME, Swim.NAME,
                    UseMagicDevice.NAME));

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

    @Override
    public String getProficiencies()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO class features
     */

}
