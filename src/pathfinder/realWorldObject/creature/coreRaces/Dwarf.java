package pathfinder.realWorldObject.creature.coreRaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.MovementSpeeds;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Dwarf extends Humanoid
{

    private final static AbilityScoreSet abilityScoreModifiers = new AbilityScoreSet(0, 0, 2, 0, 2, -2);
    private final static MovementSpeeds movement = new MovementSpeeds(20, 20, 0, 0, 0, 0);
    private final static List<Language> languages = Collections.unmodifiableList(Arrays.asList(Language.Common, Language.Dwarven));
    private final static int racePoints = 0;
    private final static SizeCategory sizeCategory = SizeCategory.Medium;

    private final static int maleBaseWeight = 150;
    private final static int femaleBaseWeight = 120;
    private final static DiceSet weightModifier = new DiceSet(8, 2);
    private final static int weightModifierMultiplier = 7;

    @Override
    public AbilityScoreSet getAbilityScoreModifiers()
    {
        return abilityScoreModifiers;
    }

    @Override
    public List<Language> getLanguages()
    {
        return languages;
    }

    @Override
    public int getRacePoints()
    {
        return racePoints;
    }

    @Override
    public SizeCategory getSizeCategory()
    {
        return sizeCategory;
    }

    @Override
    public MovementSpeeds getMoveSpeeds()
    {
        return movement;
    }

    @Override
    public List<Proficiency> getProficiencies()
    {
        return Collections.unmodifiableList(new LinkedList<Proficiency>());
    }

    @Override
    public int getMaleWeight()
    {
        return maleBaseWeight;
    }

    @Override
    public int getFemaleWeight()
    {
        return femaleBaseWeight;
    }

    @Override
    public DiceSet getWeightModifier()
    {
        return weightModifier;
    }

    @Override
    public int getWeightModifierMultiplier()
    {
        return weightModifierMultiplier;
    }

}
