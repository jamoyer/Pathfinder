package pathfinder.world;

import pathfinder.metaObjects.FastMathUtil;
import pathfinder.time.TimeKeeper;

/**
 * A world that has a set size that does not change.
 *
 * @author jacob
 *
 */
public class FiniteWorld extends BaseWorld
{
    private final TimeKeeper time;

    private final int maxWidth;
    private final int maxHeight;
    private final int maxDepth;

    private final Cell[/* width */][/* height */][/* depth */] worldArray;

    /**
     * Initializes a world with the given parameters as the maximum dimensions of the world.
     *
     * To make a 2-d world, make height = 1
     *
     * @param width
     * @param height
     * @param depth
     */
    public FiniteWorld(int width, int height, int depth)
    {
        time = new TimeKeeper();
        maxWidth = width;
        maxHeight = height;
        maxDepth = depth;

        worldArray = new Cell[maxWidth][maxHeight][maxDepth];
        for (int w = 0; w < maxWidth; w++)
        {
            for (int h = 0; h < maxHeight; h++)
            {
                for (int d = 0; d < maxDepth; d++)
                {
                    worldArray[w][h][d] = new Cell(new Coordinate(w, h, d));
                }
            }
        }
    }

    public TimeKeeper getTime()
    {
        return time;
    }

    public Cell getCellAt(final Coordinate coord)
    {
        return worldArray[coord.getWidth()][coord.getHeight()][coord.getDepth()];
    }

    public int getMaxWidth()
    {
        return maxWidth;
    }

    public int getMaxHeight()
    {
        return maxHeight;
    }

    public int getMaxDepth()
    {
        return maxDepth;
    }

    public boolean isInWorld(final Coordinate coord)
    {
        if (coord == null)
        {
            return false;
        }
        if (coord.getWidth() < 0 || coord.getWidth() >= maxWidth)
        {
            return false;
        }
        if (coord.getHeight() < 0 || coord.getHeight() >= maxHeight)
        {
            return false;
        }
        if (coord.getDepth() < 0 || coord.getDepth() >= maxDepth)
        {
            return false;
        }
        return true;
    }

    /**
     * Gets the number of cells between the two coordinates.
     *
     * @param coord1
     * @param coord2
     * @return
     * @throws IllegalArgumentException
     */
    public int getDistance(final Coordinate coord1, final Coordinate coord2) throws IllegalArgumentException
    {
        if (!isInWorld(coord1) || !isInWorld(coord2))
        {
            throw new IllegalArgumentException("Coordinates do not exist in this world.");
        }
        final int widthDiff = coord1.getWidth() - coord2.getWidth();
        final int heightDiff = coord1.getHeight() - coord2.getHeight();
        final int depthDiff = coord1.getDepth() - coord2.getDepth();
        final float distance = (float) Math.sqrt(FastMathUtil.ipow(widthDiff, 2) + FastMathUtil.ipow(heightDiff, 2) + FastMathUtil.ipow(depthDiff, 2));
        return Math.round(distance);
    }
}
