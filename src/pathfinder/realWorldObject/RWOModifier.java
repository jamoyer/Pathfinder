package pathfinder.realWorldObject;

/**
 * This object is used to modify RealWorldObjects, examples: "On fire",
 * "Bleeding", "Sleeping", "Unconscious", "Taking Damage", "Falling". These
 * modify the objects they are applied to.
 * 
 * @author jacob
 *
 */
public class RWOModifier
{
    private int duration;
    private boolean isPermanent;
    private final String description;
    private final String title;

    public RWOModifier(final String title, final String description, int duration, boolean isPermanent)
    {
        this.description = description;
        this.title = title;
        this.duration = duration;
        this.isPermanent = isPermanent;
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

	public boolean isPermanent() {
		return isPermanent;
	}
}
