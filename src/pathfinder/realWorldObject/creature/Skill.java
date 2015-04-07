package pathfinder.realWorldObject.creature;

public class Skill {

	private static String name;
	private static boolean trained;
	private static boolean armorPenalty;
	private static AbilityScore abilityScore;
	
	public Skill(String name, boolean trained, boolean armorPenalty, AbilityScore abilityScore){
		this.name = name;
		this.trained = trained;
		this.armorPenalty = armorPenalty;
		this.abilityScore = abilityScore;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isTrained() {
		return trained;
	}
	
	public boolean isArmorPenalty() {
		return armorPenalty;
	}
	
	public AbilityScore getAbilityScore() {
		return abilityScore;
	}
	
}
