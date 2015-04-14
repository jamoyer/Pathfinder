package pathfinder.realWorldObject.item.equipment;

import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.CharacterBuff;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.creature.EquippableItem;

public class SlotManager
{
    // an array for all the slots except slotless
    private final EquippableItem[] slottedItems = new EquippableItem[EquipmentSlotType.values().length - 1];
    // a list for all the slotless items
    private final List<EquippableItem> slotlessItems = new LinkedList<EquippableItem>();
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
    public List<CharacterBuff> addEquipment(final EquippableItem item)
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
            if (slottedItems[item.getSlotType().ordinal()] != null)
            {
                return null;
            }

            // add the item to the corresponding slot
            slottedItems[item.getSlotType().ordinal()] = item;
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
    public EquippableItem removeEquipment(final long itemId)
    {
        for (int i = 0; i < slottedItems.length; i++)
        {
            final EquippableItem item = slottedItems[i];
            if (item.getId() == itemId)
            {
                slottedItems[i] = null;
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
    public List<CharacterBuff> removeEquipment(final EquippableItem item)
    {
        if (removeEquipment(item.getId()) != null)
        {
            return item.getBuffs();
        }
        return null;
    }

    /**
     * Returns the equipped item for the given slot type. If slotType is slotless and there are
     * multiple slotless items, this method returns one of them. If there is no such item for the
     * given slot type, the method returns null.
     *
     * @param slotType
     * @return
     */
    public EquippableItem getItemBySlot(final EquipmentSlotType slotType)
    {
        if (slotType.equals(EquipmentSlotType.Slotless))
        {
            if (!slotlessItems.isEmpty())
            {
                return slotlessItems.get(0);
            }
            return null;
        }
        return slottedItems[slotType.ordinal()];
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
    public List<EquippableItem> setSlotSize(final SizeCategory size)
    {
        return new LinkedList<EquippableItem>();
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
