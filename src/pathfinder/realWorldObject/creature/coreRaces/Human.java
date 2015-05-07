package pathfinder.realWorldObject.creature.coreRaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScore;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.Language;
import pathfinder.realWorldObject.creature.Movement;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Human extends Humanoid
{

    private final AbilityScoreSet abilityScoreModifiers;
    private final static Movement movement = new Movement(30, 0, 0, 0, 0, 0);
    private final static List<Language> languages = Collections.unmodifiableList(Arrays.asList(Language.Common));
    private final static int racePoints = 0;
    private final static SizeCategory sizeCategory = SizeCategory.Medium;

    private final static int maleBaseWeight = 120;
    private final static int femaleBaseWeight = 85;
    private final static DiceSet weightModifier = new DiceSet(10, 2);
    private final static int weightModifierMultiplier = 5;

    public Human(AbilityScore abilityScoreBonus)
    {
        switch (abilityScoreBonus)
        {
            case Charisma:
                abilityScoreModifiers = new AbilityScoreSet(0, 0, 0, 0, 0, 2);
                break;
            case Constitution:
                abilityScoreModifiers = new AbilityScoreSet(0, 0, 2, 0, 0, 0);
                break;
            case Dexterity:
                abilityScoreModifiers = new AbilityScoreSet(0, 2, 0, 0, 0, 0);
                break;
            case Intelligence:
                abilityScoreModifiers = new AbilityScoreSet(0, 0, 0, 2, 0, 0);
                break;
            case Strength:
                abilityScoreModifiers = new AbilityScoreSet(2, 0, 0, 0, 0, 0);
                break;
            case Wisdom:
                abilityScoreModifiers = new AbilityScoreSet(0, 0, 0, 0, 2, 0);
                break;
            default:
                abilityScoreModifiers = new AbilityScoreSet(0, 0, 0, 0, 0, 0);
                break;
        }
    }

    /**
     * Overloaded constructor for when there is no preferred ability score.
     */
    public Human()
    {
        this(AbilityScoreSet.rollRandomAbilityScore());
    }

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
    public Movement getMoveSpeeds()
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