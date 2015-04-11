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
    private SizeCategory sizeCategory;
    
    public EquipableItem(EquipmentSlotType slot, SizeCategory sizeCategory)
    {
        this.slot = slot;
        this.sizeCategory = sizeCategory;
    }

    public EquipmentSlotType getSlotType()
    {
        return slot;
    }
    
    public SizeCategory getSizeCategory()
    {
        return sizeCategory;
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
