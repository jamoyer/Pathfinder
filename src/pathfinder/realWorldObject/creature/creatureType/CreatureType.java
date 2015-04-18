package pathfinder.realWorldObject.creature.creatureType;

import pathfinder.characters.classes.CreatureClass;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.Movement;

/**
 * A super class meant for things like animals, fey, dragons, aberrations,
 * constructs, magical beasts and other creature types.
 *
 * @author jacob
 *
 */
public abstract class CreatureType extends CreatureClass
{
    public abstract SizeCategory getSizeCategory();

    public abstract Movement getMoveSpeeds();

    public abstract boolean isBipedal();
}
