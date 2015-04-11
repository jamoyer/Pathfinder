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
import pathfinder.characters.skill.Acrobatics;
import pathfinder.characters.skill.Appraise;
import pathfinder.characters.skill.Bluff;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.Diplomacy;
import pathfinder.characters.skill.EscapeArtist;
import pathfinder.characters.skill.HandleAnimal;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Linguistics;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.Spellcraft;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.UseMagicDevice;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Arcana;
import pathfinder.characters.skill.knowledge.Dungeoneering;
import pathfinder.characters.skill.knowledge.Engineering;
import pathfinder.characters.skill.knowledge.Geography;
import pathfinder.characters.skill.knowledge.History;
import pathfinder.characters.skill.knowledge.Local;
import pathfinder.characters.skill.knowledge.Nature;
import pathfinder.characters.skill.knowledge.Nobility;
import pathfinder.characters.skill.knowledge.Planes;
import pathfinder.characters.skill.knowledge.Religion;
import pathfinder.characters.skill.perform.Perform;
import pathfinder.characters.skill.profession.Profession;

public class Skald extends CharacterClass
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 8;
    private static final int SKILL_RANKS_PER_LEVEL = 4;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new MediumBAB();

    private static final BaseSavingThrow FORTITUDE = new GoodSave();
    private static final BaseSavingThrow REFLEX = new BadSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Acrobatics.NAME,
                                                                                          Appraise.NAME, 
                                                                                          Bluff.NAME,
                                                                                          Climb.NAME,
                                                                                          Craft.NAME,
                                                                                          Diplomacy.NAME,
                                                                                          EscapeArtist.NAME,
                                                                                          HandleAnimal.NAME,
                                                                                          Intimidate.NAME,
                                                                                          Arcana.NAME,
                                                                                          Dungeoneering.NAME,
                                                                                          Engineering.NAME,
                                                                                          Geography.NAME,
                                                                                          History.NAME,
                                                                                          Local.NAME,
                                                                                          Nature.NAME,
                                                                                          Nobility.NAME,
                                                                                          Planes.NAME,
                                                                                          Religion.NAME,
                                                                                          Linguistics.NAME,
                                                                                          Perception.NAME,
                                                                                          Perform.NAME,
                                                                                          Profession.NAME,
                                                                                          Ride.NAME,
                                                                                          SenseMotive.NAME,
                                                                                          Spellcraft.NAME,
                                                                                          Swim.NAME,
                                                                                          UseMagicDevice.NAME
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
