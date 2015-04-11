package pathfinder.realWorldObject.creature;

import pathfinder.realWorldObject.creature.coreRaces.Race;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;

public class CharacterCreature extends Creature
{
    
    private final Race race;
    
    public CharacterCreature(CreatureType creatureType, AbilityScores baseStats, Race race)
    {
        super(creatureType, new AbilityScores(
                baseStats.getStrengthScore()+race.getAbilityScoreModifiers().getStrengthScore(),
                baseStats.getDexterityScore()+race.getAbilityScoreModifiers().getDexterityScore(),
                baseStats.getConstitutionScore()+race.getAbilityScoreModifiers().getConstitutionScore(),
                baseStats.getIntelligenceScore()+race.getAbilityScoreModifiers().getIntelligenceScore(),
                baseStats.getWisdomScore()+race.getAbilityScoreModifiers().getWisdomScore(),
                baseStats.getCharismaScore()+race.getAbilityScoreModifiers().getCharismaScore()));
        this.race = race;
    }
    


}
