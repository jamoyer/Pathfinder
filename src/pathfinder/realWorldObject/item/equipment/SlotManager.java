package pathfinder.realWorldObject.item.equipment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.CreatureBuff;
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
    public List<CreatureBuff> addEquipment(final EquippableItem item)
    {
        // check for correct size category
        if (item.getSizeCategory().ordinal() > size.ordinal())
        {
            return null;
        }

        final EquipmentSlotType slotType = item.getSlotType();

        // add the item if it is slotless
        if (slotType.equals(EquipmentSlotType.Slotless))
        {
            slotlessItems.add(item);
            return item.getBuffs();
        }

        // if this is an item held in the hands
        else if (slotType.equals(EquipmentSlotType.MainHand) || slotType.equals(EquipmentSlotType.OffHand) || slotType.equals(EquipmentSlotType.TwoHands))
        {
            // two handed items can only be fit if both hands are free
            if (slotType.equals(EquipmentSlotType.TwoHands) && slottedItems[EquipmentSlotType.OffHand.ordinal()] == null
                    && slottedItems[EquipmentSlotType.MainHand.ordinal()] == null)
            {
                slottedItems[EquipmentSlotType.TwoHands.ordinal()] = item;
                return item.getBuffs();
            }

            // if this item is one handed try to fit it in one of the hands
            else if ((slotType.equals(EquipmentSlotType.MainHand) || slotType.equals(EquipmentSlotType.OffHand)) && slottedItems[EquipmentSlotType.TwoHands.ordinal()] == null)
            {
                if (tryToFit(item, EquipmentSlotType.MainHand, EquipmentSlotType.OffHand))
                {
                    return item.getBuffs();
                }
            }
            return null;
        }

        // try to fit it if its a generic item
        else if (tryToFit(item))
        {
            return item.getBuffs();
        }

        // if this is a ring check both slots
        else if (slotType.equals(EquipmentSlotType.Ring1) || slotType.equals(EquipmentSlotType.Ring2))
        {
            if (tryToFit(item, EquipmentSlotType.Ring1, EquipmentSlotType.Ring2))
            {
                return item.getBuffs();
            }
        }
        return null;
    }

    private boolean tryToFit(final EquippableItem item)
    {
        return tryToFit(item, item.getSlotType(), null);
    }

    private boolean tryToFit(final EquippableItem item, final EquipmentSlotType preferred, final EquipmentSlotType alternate)
    {
        if (preferred != null && slottedItems[preferred.ordinal()] == null)
        {
            slottedItems[preferred.ordinal()] = item;
            return true;
        }

        if (alternate != null && slottedItems[alternate.ordinal()] == null)
        {
            slottedItems[alternate.ordinal()] = item;
            return true;
        }

        return false;
    }

    /**
     * Removes the item corresponding to the itemId and updates the equipment accordingly. If the
     * item does not exist this method returns null.
     *
     * @param itemId
     * @return
     */
    public EquippableItem removeEquipment(final long itemId)
    {
        // check slotted items
        for (int i = 0; i < slottedItems.length; i++)
        {
            final EquippableItem item = slottedItems[i];
            if (item != null && item.getId() == itemId)
            {
                slottedItems[i] = null;
                return item;
            }
        }

        // check slotless items
        final Iterator<EquippableItem> it = slotlessItems.iterator();
        while (it.hasNext())
        {
            final EquippableItem item = it.next();
            if (item.getId() == itemId)
            {
                it.remove();
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
    public List<CreatureBuff> removeEquipment(final EquippableItem item)
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
     * NOTE: this method should not be used to remove a specific ring because there are two ring
     * slots and a given ring could be put into either slot. Similarly to slotless items.
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
