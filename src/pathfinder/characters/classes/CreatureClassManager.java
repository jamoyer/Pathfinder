package pathfinder.characters.classes;

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

    public void addLevels(final CreatureClass creatureClass, int numLevels)
    {
        for (int i = 0; i < numLevels; i++)
        {
            addLevel(creatureClass);
        }
    }

    public void addLevels(final List<? extends CreatureClass> classes)
    {
        for (final CreatureClass creatureClass : classes)
        {
            addLevel(creatureClass);
        }
    }

    public void addLevel(final CreatureClass creatureClass)
    {
        if (classMap.containsKey(creatureClass.hashCode()))
        {
            final CreatureClass c = classMap.get(creatureClass.hashCode());
            final int totalLevels = c.getLevel() + creatureClass.getLevel();
            c.setLevel(totalLevels);
        }
        else
        {
            classMap.put(creatureClass.hashCode(), creatureClass);
        }
        addHealthForLevel(creatureClass);
        calcSaves();
        calcBaseAttackBonus();
        totalLevel++;
    }

    private void addHealthForLevel(final CreatureClass creatureClass)
    {
        if (rolledHealth == 0)
        {
            rolledHealth += creatureClass.getHitDieType();
        }
        else
        {
            final DiceSet dice = new DiceSet(creatureClass.getHitDieType(), 1);
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

    public List<CreatureClass> getClasses()
    {
        return Collections.unmodifiableList((List<CreatureClass>) classMap.values());
    }
}
