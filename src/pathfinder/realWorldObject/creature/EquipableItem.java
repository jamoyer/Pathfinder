package pathfinder.realWorldObject.creature;

import pathfinder.realWorldObject.Item;

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
}
