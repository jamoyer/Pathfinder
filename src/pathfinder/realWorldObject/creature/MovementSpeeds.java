package pathfinder.realWorldObject.creature;

/**
 * A list of creature movement types.
 *
 * @author jacob
 *
 */
public class MovementSpeeds implements Cloneable
{
    private int base;
    private int withArmor;
    private int fly;
    private int swim;
    private int burrow;
    private int climb;

    public MovementSpeeds(int base, int withArmor, int fly, int swim, int burrow, int climb)
    {
        this.base = base;
        this.withArmor = withArmor;
        this.fly = fly;
        this.swim = swim;
        this.burrow = burrow;
        this.climb = climb;
    }

    public int getWithArmor()
    {
        return withArmor;
    }

    public void setWithArmor(int withArmor)
    {
        this.withArmor = withArmor;
    }

    public int getBase()
    {
        return base;
    }

    public void setBase(int base)
    {
        this.base = base;
    }

    public int getFly()
    {
        return fly;
    }

    public void setFly(int fly)
    {
        this.fly = fly;
    }

    public int getSwim()
    {
        return swim;
    }

    public void setSwim(int swim)
    {
        this.swim = swim;
    }

    public int getBurrow()
    {
        return burrow;
    }

    public void setBurrow(int burrow)
    {
        this.burrow = burrow;
    }

    public int getClimb()
    {
        return climb;
    }

    public void setClimb(int climb)
    {
        this.climb = climb;
    }

    @Override
    public MovementSpeeds clone()
    {
        return new MovementSpeeds(base, withArmor, fly, swim, burrow, climb);
    }
}
