package pathfinder.realWorldObject.creature.coreRaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScores;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.Movement;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;

public class Gnome extends Humanoid implements Race
{
	
	private final static AbilityScores abilityScoreModifiers = new AbilityScores(-2,0,2,0,0,2);
	private final static Movement movement = new Movement(20,0,0,0,0,0);
	private final static List<Language> languages = 	Collections.unmodifiableList(Arrays.asList(Language.Common, Language.Gnome, Language.Sylvan));
	private final static int racePoints = 0;
	private final static SizeCategory sizeCategory = SizeCategory.Small;

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