package pathfinder.realWorldObject.creature.coreRaces;

import java.util.List;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScores;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.Movement;

public interface Race {

	public AbilityScores getAbilityScoreModifiers();
	public SizeCategory getSizeCategory();
	public List<Language> getLanguages();
	public Movement getSpeeds();
	//TODO add senses
	//TODO defensive traits
	//TODO offensive traits
	//TODO skill bonuses
	//TODO bonus feats
	//TODO spell like abilities
	public int getRacePoints();

}
