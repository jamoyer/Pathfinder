package pathfinder.realWorldObject.creature.creatureType;

import pathfinder.characters.classes.ClassInterface;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.Movement;

/**
 * A super class meant for things like animals, fey, dragons, aberrations,
 * constructs, magical beasts and other creature types.
 * 
 * @author jacob
 *
 */
public abstract class CreatureType extends ClassInterface
{
    public abstract SizeCategory getSizeCategory();

    public abstract Movement getMoveSpeeds();
}