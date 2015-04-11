package pathfinder.realWorldObject.item.equipment;

import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.BonusType;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.creature.EquipmentSlotType;

public class SlotManager
{
    private final EquipableItem[] equipedItems = new EquipableItem[EquipmentSlotType.values().length - 1];
    private final List<EquipableItem> slotlessItems = new LinkedList<EquipableItem>();
    private final int[] netBonuses = new int[BonusTarget.values().length];
    private final int[][] individualBonuses = new int[BonusTarget.values().length][BonusType.values().length];
    private final SizeCategory size;

    public SlotManager(final SizeCategory size)
    {
        this.size = size;
    }

    public void addEquipment(final EquipableItem item)
    {
        // TODO update all stuff
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
