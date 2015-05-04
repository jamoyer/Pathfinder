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

public class HalfOrc extends Humanoid
{

    private final AbilityScoreSet abilityScoreModifiers;
    private final static Movement movement = new Movement(30, 0, 0, 0, 0, 0);
    private final static List<Language> languages = Collections.unmodifiableList(Arrays.asList(Language.Common, Language.Orc));
    private final static int racePoints = 0;
    private final static SizeCategory sizeCategory = SizeCategory.Medium;

    public HalfOrc(AbilityScore abilityScoreBonus)
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
    public HalfOrc()
    {
        this(DiceSet.rollRandomAbilityScore());
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

}
