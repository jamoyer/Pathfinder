package pathfinder.realWorldObject;

import java.util.LinkedList;
import java.util.List;

/**
 * This object is a template for anything that is real and can exist in the game world. Does not
 * include things like Quests, bounties, things that cannot be sensed by one of the 5 senses, etc.
 *
 * @author jacob
 *
 */
public abstract class RealWorldObject
{
    private Coordinate coordinate;
    private int weight;
    private final long id;

    // perhaps a map or hashset would be better if we want to access these
    // modifiers often
    private final List<RWOModifier> modifiers = new LinkedList<RWOModifier>();
    private int hitPoints;
    private int maxHitPoints;

    private static long idCounter = 0;

    public RealWorldObject()
    {
        id = idCounter++;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public long getId()
    {
        return id;
    }

    public Coordinate getCoordinate()
    {
        return coordinate;
    }

    public int getMaxHP()
    {
        return maxHitPoints;
    }

    public void setMaxHP(int hp)
    {
        maxHitPoints = hp;
    }

    public int getHitPoints()
    {
        return hitPoints;
    }

    public void setHP(int hp)
    {
        hitPoints = hp;
    }

    public void addModifier(final RWOModifier modifier)
    {
        modifiers.add(modifier);
    }

    public List<RWOModifier> getModifiers()
    {
        return modifiers;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof RealWorldObject))
        {
            return false;
        }

        final RealWorldObject rwo = (RealWorldObject) o;

        return hashCode() == rwo.hashCode();
    }

    @Override
    public int hashCode()
    {
        return (int) id;
    }
}
