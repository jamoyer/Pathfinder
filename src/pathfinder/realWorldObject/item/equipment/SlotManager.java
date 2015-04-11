package pathfinder.realWorldObject.item.equipment;

import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.BonusType;
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
    private final int[] netBonuses = new int[BonusTarget.values().length];
    private final int[][] individualBonuses = new int[BonusTarget.values().length][BonusType.values().length];
    private final SizeCategory size;

    public SlotManager(final SizeCategory size)
    {
        this.size = size;
    }

    public boolean addEquipment(final EquipableItem item)
    {
        // check for correct size category
        if (item.getSizeCategory().ordinal() > size.ordinal())
        {
            return false;
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
                return false;
            }

            // add the item to the corresponding slot
            equipedItems[item.getSlotType().ordinal()] = item;
        }

        // apply the buffs from the item to the character
        final List<CharacterBuff> buffs = item.getBuffs();
        for (final CharacterBuff buff : buffs)
        {
            addBuff(buff);
        }

        return true;
    }

    private void addBuff(final CharacterBuff buff)
    {
        // check if the type stacks with itself
        if (buff.getBonusType().equals(BonusType.Untyped) || buff.getBonusType().equals(BonusType.Dodge))
        {
            individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] += buff.getValue();
            // recalculate the net for this target
            netBonuses[buff.getBonusTarget().ordinal()] += buff.getValue();
        }
        // if this new buff exceeds the existing buff, overwrite it
        else if (individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] < buff.getValue())
        {
            individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] = buff.getValue();
            // recalculate the net for this target
            netBonuses[buff.getBonusTarget().ordinal()] += buff.getValue()
                    - individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()];
        }
    }

    private void removeBuff(final CharacterBuff buff)
    {
        // check if the type stacks with itself
        if (buff.getBonusType().equals(BonusType.Untyped) || buff.getBonusType().equals(BonusType.Dodge))
        {
            individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] -= buff.getValue();
            // recalculate the net for this target
            netBonuses[buff.getBonusTarget().ordinal()] -= buff.getValue();
        }
        // if this buff is the top bonus for this target of this type,
        // recalculate the top bonus
        else if (individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] == buff.getValue())
        {
            int tempMax = 0;
            // go through every item and check if it has the top buff
            for (int i = 0; i < equipedItems.length; i++)
            {
                // check all this items buffs to see if it is the top buff for
                // this target and type
                final List<CharacterBuff> itemBuffs = equipedItems[i].getBuffs();
                for (final CharacterBuff tempBuff : itemBuffs)
                {
                    // if this buff is of the same target and type, and is
                    // larger than the current maximum, set our temp max equal
                    // to it
                    if (tempBuff.getBonusTarget().equals(buff.getBonusTarget())
                            && tempBuff.getBonusType().equals(buff.getBonusType()) && tempBuff.getValue() > tempMax)
                    {
                        tempMax = tempBuff.getValue();
                    }
                }
            }
            // overwrite our bonus with the new maximum
            individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()] = tempMax;
            // recalculate the net for this target
            netBonuses[buff.getBonusTarget().ordinal()] -= buff.getValue()
                    - individualBonuses[buff.getBonusTarget().ordinal()][buff.getBonusType().ordinal()];
        }
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
                final List<CharacterBuff> buffs = item.getBuffs();
                for (final CharacterBuff buff : buffs)
                {
                    removeBuff(buff);
                }
                return item;
            }
        }
        return null;
    }

    /**
     * Attempts to remove an item, returns true if the item was removed, returns
     * false otherwise.
     *
     * @param item
     * @return
     */
    public boolean removeEquipment(final EquipableItem item)
    {
        if (removeEquipment(item.getId()) != null)
        {
            return true;
        }
        return false;
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
     * Returns the highest bonus for a given target.
     *
     * @param target
     * @return
     */
    public int getBonusByTarget(final BonusTarget target)
    {
        return netBonuses[target.ordinal()];
    }

    /**
     * Updates slot size but keeps all equiped items the same.
     *
     * @param size
     * @return a list of items that were unequiped by the size change.
     */
    public List<EquipableItem> setSlotSize(final SizeCategory size)
    {
        return new LinkedList<EquipableItem>();
    }

    /**
     * Updates slot size and changes all equiped items to match.
     *
     * @param size
     */
    public void setSlotAndItemSize(final SizeCategory size)
    {

    }

}
