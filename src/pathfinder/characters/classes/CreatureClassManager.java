package pathfinder.characters.classes;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pathfinder.metaObjects.DiceSet;

/**
 * This class will manage all the common class bonuses for any classes that a creature may level up
 * in.
 *
 * @author Jamoyer
 *
 */
public class CreatureClassManager
{
    private final HashMap<Integer, CreatureClass> classMap = new HashMap<Integer, CreatureClass>();
    private int totalLevel = 0;
    private int rolledHealth = 0;

    private int fortitude = 0;
    private int reflex = 0;
    private int will = 0;

    private int baseAttackBonus = 0;

    public CreatureClassManager()
    {
    }

    public CreatureClassManager(List<CreatureClass> classes)
    {
        addLevels(classes);
    }

    public void addLevels(final List<? extends CreatureClass> classes)
    {
        for (final CreatureClass creatureClass : classes)
        {
            addLevel(creatureClass);
        }
    }

    /**
     * Levels up in the given class by the number of levels in it.
     *
     * @param creatureClass
     */
    public void addLevel(final CreatureClass creatureClass)
    {
        // if the creature already has levels in this class, add the new levels to it.
        if (classMap.containsKey(creatureClass.hashCode()))
        {
            final CreatureClass c = classMap.get(creatureClass.hashCode());
            final int totalLevels = c.getLevel() + creatureClass.getLevel();
            c.setLevel(totalLevels);
        }
        // add class to class map if it isn't already there
        else
        {
            classMap.put(creatureClass.hashCode(), creatureClass);
        }
        addHealthForClass(creatureClass);
        calcSaves();
        calcBaseAttackBonus();
        totalLevel++;
    }

    /**
     * Adds one level of health using the given class's hit die.
     *
     * @param creatureClass
     */
    private void addHealthForClass(final CreatureClass creatureClass)
    {
        int i = 0;
        if (i < creatureClass.getLevel())
        {
            if (rolledHealth == 0)
            {
                // take full die roll on first level
                rolledHealth += creatureClass.getHitDieType();
                i++;
            }

            // roll health randomly for this level
            final DiceSet dice = new DiceSet(creatureClass.getHitDieType(), creatureClass.getLevel() - i);
            rolledHealth += dice.getRolledTotal();
        }
    }

    private void calcSaves()
    {
        fortitude = 0;
        reflex = 0;
        will = 0;
        for (final CreatureClass creatureClass : classMap.values())
        {
            final int classLevel = classMap.get(creatureClass.hashCode()).getLevel();
            fortitude += creatureClass.getSavingThrowSet().getBaseFortitude(classLevel);
            reflex += creatureClass.getSavingThrowSet().getBaseReflex(classLevel);
            will += creatureClass.getSavingThrowSet().getBaseWill(classLevel);
        }
    }

    private void calcBaseAttackBonus()
    {
        baseAttackBonus = 0;
        for (final CreatureClass creatureClass : classMap.values())
        {
            final int classLevel = classMap.get(creatureClass.hashCode()).getLevel();
            baseAttackBonus += creatureClass.getBaseAttackBonusProgression().getBAB(classLevel);
        }
    }

    public int getTotalLevels()
    {
        return totalLevel;
    }

    public int getHealth()
    {
        return rolledHealth;
    }

    public int getFortitude()
    {
        return fortitude;
    }

    public int getReflex()
    {
        return reflex;
    }

    public int getWill()
    {
        return will;
    }

    public int getBaseAttackBonus()
    {
        return baseAttackBonus;
    }

    public Collection<CreatureClass> getClasses()
    {
        return Collections.unmodifiableCollection(classMap.values());
    }
}
