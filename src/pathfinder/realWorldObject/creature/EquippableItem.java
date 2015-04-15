package pathfinder.realWorldObject.creature;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.CreatureBuff;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.item.Item;

/**
 * Interface for something that can be equipped.
 *
 * @author jacob
 *
 */
public class EquippableItem extends Item
{
    private final EquipmentSlotType slot;
    private final SizeCategory sizeCategory;
    private final List<CreatureBuff> buffs;

    public EquippableItem(EquipmentSlotType slot, SizeCategory sizeCategory)
    {
        this.slot = slot;
        this.sizeCategory = sizeCategory;
        buffs = new LinkedList<CreatureBuff>();
    }

    public EquippableItem(EquipmentSlotType slot, SizeCategory sizeCategory, List<CreatureBuff> buffs)
    {
        this.slot = slot;
        this.sizeCategory = sizeCategory;
        if (buffs != null)
        {
            this.buffs = buffs;
        }
        else
        {
            this.buffs = new LinkedList<CreatureBuff>();
        }
    }

    public List<CreatureBuff> getBuffs()
    {
        return Collections.unmodifiableList(buffs);
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
