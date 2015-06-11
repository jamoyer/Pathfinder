package pathfinder.realWorldObject.creature.creatureType;

import pathfinder.characters.classes.CreatureClass;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.MovementSpeeds;

/**
 * A super class meant for things like animals, fey, dragons, aberrations, constructs, magical
 * beasts and other creature types.
 *
 * @author jacob
 *
 */
public abstract class CreatureType extends CreatureClass
{
    public abstract SizeCategory getSizeCategory();

    public abstract MovementSpeeds getMoveSpeeds();

    public abstract boolean isBipedal();

    /**
     * Generates a new weight for the creature type
     *
     * @param isMale
     * @param maleBase
     * @param femaleBase
     * @param modifier
     * @param modifierMultiplier
     * @return
     */
    public int calcWeight(boolean isMale)
    {
        final int base = isMale ? getMaleWeight() : getFemaleWeight();
        final int mod = getWeightModifier().getRolledTotal() * getWeightModifierMultiplier();
        return base + mod;
    }

    /**
     * Returns the base weight of males for this creature type.
     *
     * @return
     */
    public abstract int getMaleWeight();

    /**
     * Returns the base weight of females for this creature type.
     *
     * @return
     */
    public abstract int getFemaleWeight();

    /**
     * Returns the dice set used to vary the weight.
     *
     * @return
     */
    public abstract DiceSet getWeightModifier();

    /**
     * Returns how much the weight modifier should be multiplied by.
     *
     * @return
     */
    public abstract int getWeightModifierMultiplier();
}
