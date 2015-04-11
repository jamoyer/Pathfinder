package pathfinder.characters.classes.hybridClasses;

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
import pathfinder.characters.skill.Acrobatics;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.EscapeArtist;
import pathfinder.characters.skill.HandleAnimal;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Dungeoneering;
import pathfinder.characters.skill.knowledge.Local;
import pathfinder.characters.skill.profession.Profession;

public class Brawler extends CharacterClass
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 10;
    private static final int SKILL_RANKS_PER_LEVEL = 4;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new GoodSave();
    private static final BaseSavingThrow WILL = new BadSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Acrobatics.NAME,
                                                                                          Climb.NAME,
                                                                                          Craft.NAME,
                                                                                          EscapeArtist.NAME,
                                                                                          HandleAnimal.NAME,
                                                                                          Intimidate.NAME,
                                                                                          Dungeoneering.NAME,
                                                                                          Local.NAME,
                                                                                          Perception.NAME,
                                                                                          Profession.NAME,
                                                                                          Ride.NAME,
                                                                                          SenseMotive.NAME,
                                                                                          Swim.NAME
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
