package pathfinder.characters.classes.coreClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.FastBAB;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Diplomacy;
import pathfinder.characters.skill.HandleAnimal;
import pathfinder.characters.skill.Heal;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.Spellcraft;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Nobility;
import pathfinder.characters.skill.knowledge.Religion;
import pathfinder.characters.skill.profession.Profession;

public class Paladin extends CharacterClass
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 10;
    private static final int SKILL_RANKS_PER_LEVEL = 2;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new BadSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Craft.NAME,
                                                                                          Diplomacy.NAME,
                                                                                          HandleAnimal.NAME,
                                                                                          Heal.NAME,
                                                                                          Nobility.NAME,
                                                                                          Religion.NAME,
                                                                                          Profession.NAME,
                                                                                          Ride.NAME,
                                                                                          SenseMotive.NAME,
                                                                                          Spellcraft.NAME
                                                                                          ));

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
