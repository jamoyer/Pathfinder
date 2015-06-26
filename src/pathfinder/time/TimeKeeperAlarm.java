package pathfinder.time;

public class TimeKeeperAlarm implements Comparable<TimeKeeperAlarm>
{
    private final TimeWatcher watcher;
    private final TickCount timeToAlertWatcher;

    public TimeKeeperAlarm(final TimeWatcher watcher, final TickCount timeToAlertWatcher) throws IllegalArgumentException
    {
        if (watcher == null || timeToAlertWatcher == null)
        {
            throw new IllegalArgumentException("Waiter and time cannot be null.");
        }
        this.watcher = watcher;
        this.timeToAlertWatcher = timeToAlertWatcher;
    }

    public TimeWatcher getWatcher()
    {
        return watcher;
    }

    public TickCount getTimeToAlertWatcher()
    {
        return timeToAlertWatcher;
    }

    public void alertWatcher(final TickCount currentTime)
    {
        if (currentTime.getNumTicks() < timeToAlertWatcher.getNumTicks())
        {
            throw new RuntimeException("Watcher was alerted before the desired time.");
        }
        watcher.doTimeDependentAction(currentTime);
    }

    @Override
    public int compareTo(TimeKeeperAlarm alarm)
    {
        return timeToAlertWatcher.compareTo(alarm.timeToAlertWatcher);
    }
}