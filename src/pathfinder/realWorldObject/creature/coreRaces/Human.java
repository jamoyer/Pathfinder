package pathfinder.realWorldObject.creature.coreRaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScore;
import pathfinder.realWorldObject.creature.AbilityScores;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.Movement;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;

public class Human extends Humanoid implements Race
{
	
	private final AbilityScores abilityScoreModifiers;
	private final static Movement movement = new Movement(30,0,0,0,0,0);
	private final static List<Language> languages = 	Collections.unmodifiableList(Arrays.asList(Language.Common));
	private final static int racePoints = 0;
	private final static SizeCategory sizeCategory = SizeCategory.Medium;
	
	public Human(AbilityScore abilityScoreBonus)
	{
		switch(abilityScoreBonus) 
		{
		case Charisma:
			abilityScoreModifiers = new AbilityScores(0, 0, 0, 0, 0, 2);
			break;
		case Constitution:
			abilityScoreModifiers = new AbilityScores(0, 0, 2, 0, 0, 0);
			break;
		case Dexterity:
			abilityScoreModifiers = new AbilityScores(0, 2, 0, 0, 0, 0);
			break;
		case Intelligence:
			abilityScoreModifiers = new AbilityScores(0, 0, 0, 2, 0, 0);
			break;
		case Strength:
			abilityScoreModifiers = new AbilityScores(2, 0, 0, 0, 0, 0);
			break;
		case Wisdom:
			abilityScoreModifiers = new AbilityScores(0, 0, 0, 0, 2, 0);
			break;
		default:
			abilityScoreModifiers = new AbilityScores(0, 0, 0, 0, 0, 0);
			break;
		}
	}

	@Override
	public AbilityScores getAbilityScoreModifiers() {
		return abilityScoreModifiers;
	}

	@Override
	public List<Language> getLanguages() {
		return languages;
	}

	@Override
	public int getRacePoints() {
		return racePoints;
	}

	@Override
	public SizeCategory getSizeCategory() 
	{
		return sizeCategory;
	}

	@Override
	public Movement getMoveSpeeds() {
		return movement;
	}

}