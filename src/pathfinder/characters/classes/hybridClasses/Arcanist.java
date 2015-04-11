package pathfinder.characters.classes.hybridClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.SlowBAB;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Appraise;
import pathfinder.characters.skill.Fly;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Linguistics;
import pathfinder.characters.skill.Spellcraft;
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
import pathfinder.characters.skill.profession.Profession;

public class Arcanist extends CharacterClass
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 6;
    private static final int SKILL_RANKS_PER_LEVEL = 2;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new SlowBAB();

    private static final BaseSavingThrow FORTITUDE = new BadSave();
    private static final BaseSavingThrow REFLEX = new BadSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Appraise.NAME,
                                                                                          Craft.NAME,
                                                                                          Fly.NAME,
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
                                                                                          Profession.NAME,
                                                                                          Spellcraft.NAME,
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
