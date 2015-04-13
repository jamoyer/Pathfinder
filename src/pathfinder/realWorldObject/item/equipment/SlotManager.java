package pathfinder.realWorldObject.item.equipment;

import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.CharacterBuff;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.creature.EquipmentSlotType;

public class SlotManager
{
    // an array for all the slots except slotless
    private final EquipableItem[] equipedItems = new EquipableItem[EquipmentSlotType.values().length - 1];
    // a list for all the slotless items
    private final List<EquipableItem> slotlessItems = new LinkedList<EquipableItem>();
    private final SizeCategory size;

    public SlotManager(final SizeCategory size)
    {
        this.size = size;
    }

    /**
     * Adds the item and returns a list of new buffs to apply from the item. Returns null if the
     * item could not be added.
     *
     * @param item
     * @return
     */
    public List<CharacterBuff> addEquipment(final EquipableItem item)
    {
        // check for correct size category
        if (item.getSizeCategory().ordinal() > size.ordinal())
        {
            return null;
        }

        // add the item if it is slotless
        if (item.getSlotType().equals(EquipmentSlotType.Slotless))
        {
            slotlessItems.add(item);
        }
        else
        {
            // check to see if the slot is already being used
            if (equipedItems[item.getSlotType().ordinal()] != null)
            {
                return null;
            }

            // add the item to the corresponding slot
            equipedItems[item.getSlotType().ordinal()] = item;
        }

        return item.getBuffs();
    }

    /**
     * Removes the item corresponding to the itemId and updates the equipment
     * accordingly. If the item does not exist this method returns null.
     *
     * @param itemId
     * @return
     */
    public EquipableItem removeEquipment(final long itemId)
    {
        for (int i = 0; i < equipedItems.length; i++)
        {
            final EquipableItem item = equipedItems[i];
            if (item.getId() == itemId)
            {
                equipedItems[i] = null;
                return item;
            }
        }
        return null;
    }

    /**
     * Attempts to remove an item, returns a list of buffs to remove if successful and returns null
     * otherwise.
     *
     * @param item
     * @return
     */
    public List<CharacterBuff> removeEquipment(final EquipableItem item)
    {
        if (removeEquipment(item.getId()) != null)
        {
            return item.getBuffs();
        }
        return null;
    }

    /**
     * Returns the size category this SlotManager is.
     *
     * @return
     */
    public SizeCategory getSizeCategory()
    {
        return size;
    }

    /**
     * Updates slot size but keeps all equipped items the same.
     *
     * @param size
     * @return a list of items that were unequipped by the size change.
     */
    public List<EquipableItem> setSlotSize(final SizeCategory size)
    {
        return new LinkedList<EquipableItem>();
    }

    /**
     * Updates slot size and changes all equipped items to match.
     *
     * @param size
     */
    public void setSlotAndItemSize(final SizeCategory size)
    {

    }

}
