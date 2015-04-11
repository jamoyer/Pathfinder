package pathfinder.realWorldObject.creature;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.item.Item;

/**
 * Interface for something that can be equipped.
 * 
 * @author jacob
 *
 */
public class EquipableItem extends Item
{
    private EquipmentSlotType slot;

    public EquipmentSlotType getSlotType()
    {
        return slot;
    }

    @Override
    public int getCost()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getWeight()
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
