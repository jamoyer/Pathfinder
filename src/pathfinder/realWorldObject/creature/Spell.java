package pathfinder.realWorldObject.creature;
import java.util.List;

import pathfinder.realWorldObject.item.Item;

public class Spell {
	
	private String name;
	private SpellSchool school;
	//TODO TIME
	//TODO ENERGY TYPE
	//TODO energyTypes
	//TODO levelReqs
	private boolean verbal;
	private boolean semantic;
	List<Item> materials;
	List<Item> focus;
	List<Item> divineFocus;
	int numTargets;
	int baseRange;
	int randModifier;
	//TODO magical effects, and others to be determined

}
