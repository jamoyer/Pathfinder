package pathfinder.world;

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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + depth;
        result = prime * result + height;
        result = prime * result + width;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (depth != other.depth)
        {
            return false;
        }
        if (height != other.height)
        {
            return false;
        }
        if (width != other.width)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Coordinate [width=" + width + ", height=" + height + ", depth=" + depth + "]";
    }
}
