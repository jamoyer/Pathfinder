package pathfinder.realWorldObject;

import java.util.LinkedList;
import java.util.List;

import pathfinder.world.Coordinate;

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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ id >>> 32);
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final RealWorldObject other = (RealWorldObject) obj;
        if (id != other.id)
        {
            return false;
        }
        return true;
    }

    public void addModifier(final RWOModifier modifier)
    {
        modifiers.add(modifier);
    }

    public List<RWOModifier> getModifiers()
    {
        return modifiers;
    }

    /**
     * Returns a list of this Real World Object's properties as Strings. Each property is of the
     * form "name: value"
     *
     * @return
     */
    public List<String> getProperties()
    {
        final List<String> properties = new LinkedList<String>();
        //properties.add("RWOType: " + this.getClass().getSimpleName());
        properties.add("ID: " + id);
        properties.add("Weight: " + weight);
        properties.add("Max HP: " + maxHitPoints);
        properties.add("HP: " + hitPoints);
        return properties;
    }
}
