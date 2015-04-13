package pathfinder.characters.classes.coreClasses;

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
import pathfinder.characters.skill.DisableDevice;
import pathfinder.characters.skill.Disguise;
import pathfinder.characters.skill.EscapeArtist;
import pathfinder.characters.skill.Linguistics;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.SleightOfHand;
import pathfinder.characters.skill.Stealth;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.UseMagicDevice;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Dungeoneering;
import pathfinder.characters.skill.knowledge.Local;
import pathfinder.characters.skill.perform.Perform;
import pathfinder.characters.skill.profession.Profession;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Rogue extends CharacterClass
{
    public Rogue(int level)
    {
        super(level);
        // TODO Auto-generated constructor stub
    }

    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 8;
    private static final int SKILL_RANKS_PER_LEVEL = 8;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new MediumBAB();

    private static final BaseSavingThrow FORTITUDE = new BadSave();
    private static final BaseSavingThrow REFLEX = new GoodSave();
    private static final BaseSavingThrow WILL = new BadSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections.unmodifiableList(Arrays.asList(Acrobatics.NAME,
            Appraise.NAME, Bluff.NAME, Climb.NAME, Craft.NAME, Diplomacy.NAME, DisableDevice.NAME, Disguise.NAME,
            EscapeArtist.NAME, Dungeoneering.NAME, Local.NAME, Linguistics.NAME, Perception.NAME, Perform.NAME,
            Profession.NAME, SenseMotive.NAME, SleightOfHand.NAME, Stealth.NAME, Swim.NAME, UseMagicDevice.NAME));

    private static final List<Proficiency> PROFICIENCIES = Collections.unmodifiableList(Arrays.asList(
            Proficiency.SimpleWeapon, Proficiency.Shield));

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
    public List<Proficiency> getProficiencies()
    {
        return PROFICIENCIES;
    }

    /*
     * TODO class features
     */

}
