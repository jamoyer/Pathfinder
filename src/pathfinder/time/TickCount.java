package pathfinder.time;

/**
 * Simple wrapper for an integer representing some number of ticks in the time keeper. This will
 * help us keep time data consistent.
 *
 * @author Jacob Moyer
 *
 */
public class TickCount implements Comparable<TickCount>, Cloneable
{
    private int numTicks;

    public TickCount()
    {
        numTicks = 0;
    }

    public TickCount(final int numTicks) throws IllegalArgumentException
    {
        if (TickCount.checkForValidTicks(numTicks))
        {
            this.numTicks = numTicks;
        }
    }

    public TickCount(final long numTicks) throws IllegalArgumentException
    {
        if (TickCount.checkForValidTicks((int) numTicks))
        {
            this.numTicks = (int) numTicks;
        }
    }

    public int getNumTicks()
    {
        return numTicks;
    }

    public void setNumTicks(final int numTicks) throws IllegalArgumentException
    {
        if (TickCount.checkForValidTicks(numTicks))
        {
            this.numTicks = numTicks;
        }
    }

    public void addTicks(final TickCount ticks)
    {
        numTicks += ticks.numTicks;
    }

    public TickCount add(final TickCount ticks)
    {
        return new TickCount(numTicks + ticks.getNumTicks());
    }

    @Override
    public int compareTo(final TickCount arg0)
    {
        return Integer.compare(numTicks, arg0.getNumTicks());
    }

    public static boolean checkForValidTicks(final int ticks) throws IllegalArgumentException
    {
        if (ticks < 0)
        {
            throw new IllegalArgumentException("Number of ticks must be non-negative.");
        }
        return true;
    }

    @Override
    public TickCount clone()
    {
        return new TickCount(numTicks);
    }
}