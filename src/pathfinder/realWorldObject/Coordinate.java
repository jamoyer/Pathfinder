package pathfinder.realWorldObject;

/**
 * If our game world is laid out in an imaginary 3-dimensional grid broken into
 * chunks, then this object represents a location in the world.
 * 
 * @author jacob
 *
 */
public class Coordinate implements Cloneable
{
    private int x;
    private int y;
    private int z;

    public Coordinate()
    {

    }

    public Coordinate(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setZ(int z)
    {
        this.z = z;
    }

    @Override
    public Object clone()
    {
        return new Coordinate(x, y, z);
    }
}
