package pathfinder.world;

import pathfinder.realWorldObject.Cell;
import pathfinder.realWorldObject.Coordinate;

public class FiniteWorld extends BaseWorld
{
    private final int maxWidth;
    private final int maxHeight;
    private final int maxDepth;

    private final Cell[/* width */][/* height */][/* depth */] worldArray;

    public FiniteWorld(int width, int height, int depth)
    {
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

    public Cell getCellAt(int width, int height, int depth)
    {
        return worldArray[width][height][depth];
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
}
