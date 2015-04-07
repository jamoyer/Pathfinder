package pathfinder.realWorldObject.creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pathfinder.realWorldObject.RealWorldObject;

/**
 * Handles creature inventory
 * 
 * @author jacob
 *
 */
public class Inventory
{
    private final Map<Long, RealWorldObject> contents = new HashMap<Long, RealWorldObject>();
    private long totalMass;

    public void addItem(final RealWorldObject rwo)
    {
        contents.put(rwo.getId(), rwo);
        totalMass += rwo.getMass();
    }

    public RealWorldObject viewItem(long id)
    {
        return contents.get(id);
    }

    public RealWorldObject removeItem(long id)
    {
        totalMass -= contents.get(id).getMass();
        return contents.remove(id);
    }

    public List<RealWorldObject> viewAll()
    {
        return new ArrayList<RealWorldObject>(contents.values());
    }

    public void removeAll()
    {
        totalMass = 0;
        contents.clear();
    }

    public long getTotalMass()
    {
        return totalMass;
    }
}
