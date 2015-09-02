package pathfinder.realWorldObject;

/**
 * This class serves as a description of the dimensions that a real world object has in cells.
 *
 * TODO: In order to have objects which are not perfectly rectangular we will have to create
 * multiple objects with RWODimensions and somehow tack them together. For example: a tree might
 * have a trunk being tall and skinny, and it might have a top which is large and round.
 *
 * @author Jacob Moyer
 *
 */
public class RWODimension
{
    private final double width;
    private final double height;
    private final double depth;
    private final double volume;

    public RWODimension(double width, double height, double depth)
    {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.volume = width * height * depth;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public double getDepth()
    {
        return depth;
    }

    public double getVolume()
    {
        return this.volume;
    }
}