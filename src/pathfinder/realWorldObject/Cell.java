package pathfinder.realWorldObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * If our game world is laid out in an imaginary 3-dimensional grid broken into
 * chunks, then this object represents a single unit of space, a 1 meter cube.
 * We can have infinite RealWorldObjects stacked inside this cube.
 * 
 * @author jacob
 *
 */
public class Cell
{
    private final Map<Long, RealWorldObject> stackedObjects = new HashMap<Long, RealWorldObject>();
    private final Coordinate coordinate;

    public Cell(final Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }

    public void addRWO(final RealWorldObject rwo)
    {
        stackedObjects.put(rwo.getId(), rwo);
    }

    public RealWorldObject removeRWO(final long id)
    {
        return stackedObjects.remove(id);
    }

    public List<RealWorldObject> getAllRWO()
    {
        return new ArrayList<RealWorldObject>(stackedObjects.values());
    }

    public void removeAllRWO()
    {
        stackedObjects.clear();
    }

    public Coordinate getCoordinate()
    {
        return (Coordinate) coordinate.clone();
    }
}
