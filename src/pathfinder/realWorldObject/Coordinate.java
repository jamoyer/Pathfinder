package pathfinder.realWorldObject;

/**
 * If our game world is laid out in an imaginary 3-dimensional grid broken into chunks, then this
 * object represents a location in the world.
 *
 * @author jacob
 *
 */
public class Coordinate implements Cloneable
{
    private final int width;
    private final int height;
    private final int depth;

    public Coordinate(int width, int height, int depth)
    {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getDepth()
    {
        return depth;
    }

    @Override
    public Object clone()
    {
        return new Coordinate(width, height, depth);
    }
}
