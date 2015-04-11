package pathfinder.realWorldObject.creature.coreRaces;

import java.util.List;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScores;
import pathfinder.realWorldObject.creature.Language;

public interface Race {
	
	public AbilityScores getAbilityScoreModifiers();
	public SizeCategory getSizeCategory();
	public List<Language> getLanguages();
	//TODO add senses
	//TODO defensive traits
	//TODO offensive traits
	//TODO skill bonuses
	//TODO bonus feats
	//TODO spell like abilities
	public int getRacePoints();

}
