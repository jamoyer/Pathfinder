package pathfinder.action;

import pathfinder.time.TickCount;

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
        // TODO: implement this class more completely
        //this.numTicks = new TickCount((int) (seconds * TimeKeeper.getTicksPerSecond()));
        this.numTicks = new TickCount(0);
    }

    public TickCount getNumTicks()
    {
        return numTicks;
    }
}
