package pathfinder.realWorldObject;

import java.util.LinkedList;
import java.util.List;

/**
 * This object is a template for anything that is real and can exist in the game
 * world. Does not include things like Quests, bounties, things that cannot be
 * sensed by one of the 5 senses, etc.
 * 
 * @author jacob
 *
 */
public class RealWorldObject
{
    private Coordinate coordinate;
    private long mass;
    private final long id;

    // perhaps a map or hashset would be better if we want to access these
    // modifiers often
    private final List<RWOModifier> modifiers = new LinkedList<RWOModifier>();
    private int hitPoints;

    public RealWorldObject()
    {
        id = 0; // TODO create a system for making unique id's, possibly a
                // idmaker class that has an id counter
    }

    public long getMass()
    {
        return mass;
    }

    public long getId()
    {
        return id;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    public int getHitPoints()
    {
        return hitPoints;
    }

    public void addModifier(final RWOModifier modifier)
    {
        modifiers.add(modifier);
    }

    public List<RWOModifier> getModifiers()
    {
        return modifiers;
    }
}
