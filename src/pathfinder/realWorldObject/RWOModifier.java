package pathfinder.realWorldObject;

/**
 * This object is used to modify RealWorldObjects, examples: "On fire", "Bleeding", "Sleeping",
 * "Unconscious", "Taking Damage", "Falling". These modify the objects they are applied to.
 *
 * @author jacob
 *
 */
public class RWOModifier
{
    private static long idCounter = 0;

    private final long id;
    private final long sourceId;
    private final int duration;
    private final boolean isPermanent;
    private final String description;
    private final String title;

    public RWOModifier(final String title, final String description, int duration, boolean isPermanent, final long sourceId)
    {
        this.sourceId = sourceId;
        this.description = description;
        this.title = title;
        this.duration = duration;
        this.isPermanent = isPermanent;
        id = idCounter++;
    }

    public long getSourceId()
    {
        return sourceId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public int getDuration()
    {
        return duration;
    }

    public boolean isPermanent()
    {
        return isPermanent;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o instanceof RWOModifier))
        {
            return false;
        }

        final RWOModifier temp = (RWOModifier) o;

        if (hashCode() != temp.hashCode())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        return (int) id;
    }
}
