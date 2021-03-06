package pathfinder.characters.classes.baseClasses;

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
import pathfinder.characters.skill.Bluff;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.Diplomacy;
import pathfinder.characters.skill.HandleAnimal;
import pathfinder.characters.skill.Intimidate;
import pathfinder.characters.skill.Ride;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.profession.Profession;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Cavalier extends CharacterClass
{
	public Cavalier(int level)
    {
        super(level);
        // TODO Auto-generated constructor stub
    }

    /*
	 * Basic Class Stats
	 */
	private static final int HIT_DIE = 10;
	private static final int SKILL_RANKS_PER_LEVEL = 4;
	private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new FastBAB();

	private static final BaseSavingThrow FORTITUDE = new GoodSave();
	private static final BaseSavingThrow REFLEX = new BadSave();
	private static final BaseSavingThrow WILL = new BadSave();
	private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(
			FORTITUDE, REFLEX, WILL);

	// needs to be unmodifiable so that when this list is passed it is not
	// accidentally modified, which could be disastrous
	private static final List<String> SKILLS = Collections
			.unmodifiableList(Arrays.asList(Bluff.NAME, Climb.NAME, Craft.NAME,
					Diplomacy.NAME, HandleAnimal.NAME, Intimidate.NAME,
					Profession.NAME, Ride.NAME, SenseMotive.NAME, Swim.NAME));

	private static final List<Proficiency> PROFICIENCIES = Collections.unmodifiableList(Arrays.asList(
            Proficiency.SimpleWeapon, Proficiency.MartialWeapon, Proficiency.LightArmor, Proficiency.MediumArmor,
            Proficiency.HeavyArmor, Proficiency.Shield));

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