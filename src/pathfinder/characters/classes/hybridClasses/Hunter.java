package pathfinder.characters.classes.hybridClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.MediumBAB;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.HandleAnimal;
import pathfinder.characters.skill.Heal;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.Spellcraft;
import pathfinder.characters.skill.Stealth;
import pathfinder.characters.skill.Survival;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Dungeoneering;
import pathfinder.characters.skill.knowledge.Geography;
import pathfinder.characters.skill.knowledge.Nature;
import pathfinder.characters.skill.profession.Profession;

public class Hunter extends CharacterClass
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 8;
    private static final int SKILL_RANKS_PER_LEVEL = 6;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new MediumBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new GoodSave();
    private static final BaseSavingThrow WILL = new BadSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Climb.NAME,
                                                                                          Craft.NAME,
                                                                                          HandleAnimal.NAME,
                                                                                          Heal.NAME,
                                                                                          Intimidate.NAME,
                                                                                          Dungeoneering.NAME,
                                                                                          Geography.NAME,
                                                                                          Nature.NAME,
                                                                                          Perception.NAME,
                                                                                          Profession.NAME,
                                                                                          Ride.NAME,
                                                                                          Spellcraft.NAME,
                                                                                          Stealth.NAME,
                                                                                          Survival.NAME,
                                                                                          Swim.NAME));

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
