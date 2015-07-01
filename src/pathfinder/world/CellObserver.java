package pathfinder.world;

import pathfinder.realWorldObject.RealWorldObject;

public interface CellObserver
{
    public void rwoEntersCellAction(final Cell location, final RealWorldObject rwo);

    public void rwoLeavesCellAction(final Cell location, final RealWorldObject rwo);
}