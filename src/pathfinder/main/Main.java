package pathfinder.main;

import pathfinder.characters.classes.coreClasses.Barbarian;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.CharacterCreature;
import pathfinder.realWorldObject.creature.Creature;
import pathfinder.realWorldObject.creature.coreRaces.Dwarf;

public class Main
{

    public static void main(String[] args)
    {
        final AbilityScoreSet baseScores = AbilityScoreSet.roll4d6AbilityScoreSet();
        final Dwarf dwarf = new Dwarf();
        final Barbarian bar = new Barbarian(5);
        final Creature steve = new CharacterCreature(baseScores, dwarf, bar);
        steve.getArmorClass();
        System.out.println("Successfully created Steve.");
    }

}
