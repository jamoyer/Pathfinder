package pathfinder.world;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pathfinder.realWorldObject.RealWorldObject;

/**
 * If our game world is laid out in an imaginary 3-dimensional grid broken into chunks, then this
 * object represents a single unit of space, 1 cube. We can have infinite RealWorldObjects stacked
 * inside this cube.
 *
 * @author jacob
 *
 */
public class Cell
{
    // hopefully a map isn't too much memory for every cell to have one. We may need to build our
    // own implementation.
    private final Map<Long, RealWorldObject> stackedObjects = new HashMap<Long, RealWorldObject>(3);
    private final Set<CellObserver> observers = new HashSet<CellObserver>();
    private final Coordinate coordinate;

    public Cell(final Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }

    public void addRWO(final RealWorldObject rwo)
    {
        stackedObjects.put(rwo.getId(), rwo);
        for(final CellObserver ob : observers)
        {
            ob.rwoEntersCellAction(this, rwo);
        }
    }

    public RealWorldObject removeRWO(final long id)
    {
        final RealWorldObject rwo = stackedObjects.remove(id);
        for(final CellObserver ob : observers)
        {
            ob.rwoLeavesCellAction(this, rwo);
        }
        return rwo;
    }

    public RealWorldObject removeRWO(final RealWorldObject rwo)
    {
        return removeRWO(rwo.getId());
    }

    /**
     * Returns an unmodifiable Collection of all the Real World Objects in this cell.
     *
     * @return
     */
    public Collection<RealWorldObject> viewAllRWO()
    {
        return Collections.unmodifiableCollection(stackedObjects.values());
    }

    public void clear()
    {
        stackedObjects.clear();
    }

    public Coordinate getCoordinate()
    {
        return (Coordinate) coordinate.clone();
    }

    public void registerObserver(final CellObserver observer)
    {
        observers.add(observer);
    }

    public void unregisterObserver(final CellObserver observer)
    {
        observers.remove(observer);
    }
}
