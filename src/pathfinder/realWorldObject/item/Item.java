package pathfinder.realWorldObject.item;

import pathfinder.realWorldObject.NonAnimate;
import pathfinder.realWorldObject.SizeCategory;

/**
 * This includes all items in Pathfinder, ex: gear, artifacts, general goods,
 * ... almost self explanatory.
 * 
 * @author jacob
 *
 */
public abstract class Item extends NonAnimate
{
    public abstract int getCost();
    public abstract long getWeight();
}
