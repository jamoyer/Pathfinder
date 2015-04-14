package pathfinder.realWorldObject.creature;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.CharacterBuff;
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
    private final List<CharacterBuff> buffs;

    public EquippableItem(EquipmentSlotType slot, SizeCategory sizeCategory)
    {
        this.slot = slot;
        this.sizeCategory = sizeCategory;
        buffs = new LinkedList<CharacterBuff>();
    }

    public EquippableItem(EquipmentSlotType slot, SizeCategory sizeCategory, List<CharacterBuff> buffs)
    {
        this.slot = slot;
        this.sizeCategory = sizeCategory;
        this.buffs = buffs;
    }

    public List<CharacterBuff> getBuffs()
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
