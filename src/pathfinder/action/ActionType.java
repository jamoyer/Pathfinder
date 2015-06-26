package pathfinder.action;

import pathfinder.time.TickCount;
import pathfinder.time.TimeKeeper;

public enum ActionType
{
    Standard(3),
    Move(3),
    FullRound(6),
    Swift(1),
    Immediate(1),
    Free(.5),
    AttackOfOpportunity(3),
    NotAnAction(0); // might not be necessary

    private final TickCount numTicks;

    private ActionType(final double seconds)
    {
        // convert from number of seconds to number of ticks
        this.numTicks = new TickCount((int) (seconds * TimeKeeper.getTicksPerSecond()));
    }

    public TickCount getNumTicks()
    {
        return numTicks;
    }
}
