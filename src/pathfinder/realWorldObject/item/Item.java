package pathfinder.realWorldObject.item;

import pathfinder.realWorldObject.NonAnimate;

/**
 * This includes all items in Pathfinder, ex: gear, artifacts, general goods, ... almost self
 * explanatory.
 *
 * @author jacob
 *
 */
public abstract class Item extends NonAnimate
{
    private int cost;

    public Item(int cost)
    {
        this.cost = cost;
    }

    public Item()
    {
        this.cost = 0;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }
}
