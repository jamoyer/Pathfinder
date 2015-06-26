package pathfinder.time;

import java.util.Collections;
import java.util.PriorityQueue;

import pathfinder.action.ActionType;

/**
 * An interface for keeping track of the world's time. There may be several different ways we will
 * want to implement a Time Keeper but they should have a consistent interface so here it is.
 *
 * @author Jacob Moyer
 *
 */
public class TimeKeeper
{
    public static final int NUM_TICKS_PER_SECOND = 5;
    public static final int NUM_TICKS_PER_MINUTE = NUM_TICKS_PER_SECOND * 60;
    public static final int NUM_TICKS_PER_HOUR = NUM_TICKS_PER_MINUTE * 60;
    public static final int NUM_TICKS_PER_DAY = NUM_TICKS_PER_HOUR * 24;
    public static final int NUM_TICKS_PER_WEEK = NUM_TICKS_PER_DAY * 7;
    public static final int NUM_TICKS_PER_FORTNIGHT = NUM_TICKS_PER_WEEK * 2;
    public static final int NUM_TICKS_PER_MONTH = NUM_TICKS_PER_DAY * 30;
    public static final int NUM_TICKS_PER_YEAR = NUM_TICKS_PER_DAY * 365;
    public static final long NUM_TICKS_UNTIL_HL3 = Long.MAX_VALUE;

    private final TickCount totalTicks;

    /*
     * Priority queue for time keepers so we always get the alarm that needs to be activated the
     * soonest. This needs to be in reverse order so it becomes a min heap and gets the soonest
     * alarm rather than the later.
     */
    private final PriorityQueue<TimeKeeperAlarm> alarmQueue = new PriorityQueue<TimeKeeperAlarm>(10, Collections.reverseOrder());

    /**
     * Initializes a new Time Keeper
     */
    public TimeKeeper()
    {
        totalTicks = new TickCount();
    }

    /**
     * Initializes a new Time Keeper to start of with a number of ticks.
     *
     * @param initialTicks
     */
    public TimeKeeper(final TickCount initialTicks)
    {
        totalTicks = initialTicks;
    }

    /**
     * Gets the total number of ticks that have passed in the game.
     *
     * @return
     */
    public TickCount getTotalTicks()
    {
        return totalTicks.clone();
    }

    /**
     * Advances the time keeper by one tick.
     */
    public void advanceTimeOneTick()
    {
        totalTicks.setNumTicks(totalTicks.getNumTicks() + 1);
        timeChanged();
    }

    /**
     * Advances the time keeper by a given number of ticks.
     *
     * @param ticks
     */
    public void advanceTime(final TickCount ticks)
    {
        totalTicks.addTicks(ticks);
        timeChanged();
    }

    /**
     * Advances the time keeper by the length of an action type.
     *
     * @param action
     */
    public void advanceTime(final ActionType action)
    {
        totalTicks.addTicks(action.getNumTicks());
        timeChanged();
    }

    public void registerTimeKeeperAlarm(final TimeKeeperAlarm alarm)
    {
        alarmQueue.add(alarm);
    }

    /**
     * Call this method whenever the time changes. It activates all alarms that need to be because
     * of the time change.
     */
    private void timeChanged()
    {
        TimeKeeperAlarm alarm = null;
        while ((alarm = alarmQueue.peek()) != null && alarm.getTimeToAlertWatcher().getNumTicks() <= totalTicks.getNumTicks())
        {
            alarmQueue.poll().alertWatcher(totalTicks.clone());
        }
    }
}
