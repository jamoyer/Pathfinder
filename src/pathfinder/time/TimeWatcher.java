package pathfinder.time;

public interface TimeWatcher
{
    public void doTimeDependentAction(final TickCount currentTime);
}