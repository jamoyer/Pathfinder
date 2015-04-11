package pathfinder.realWorldObject.creature.coreRaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScores;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.Movement;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;

public class Elf extends Humanoid implements Race
{
	
	private final static AbilityScores abilityScoreModifiers = new AbilityScores(0,2,-2,2,0,0);
	private final static Movement movement = new Movement(30,0,0,0,0,0);
	private final static List<Language> languages = 	Collections.unmodifiableList(Arrays.asList(Language.Common, Language.Elven));
	private final static int racePoints = 0;
	private final static SizeCategory sizeCategory = SizeCategory.Medium;

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
