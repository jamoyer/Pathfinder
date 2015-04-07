package pathfinder.realWorldObject.creature;

/**
 * A template for equipmentSlots.
 * 
 * I'm not sure how necessary this class will be once we get stuff implemented.
 * 
 * @author jacob
 *
 */
public class EquipmentSlot
{
    private final EquipmentSlotType slotType;
    private final String name;
    private EquipableItem item; // must match slotType

    public EquipmentSlot(final String name, final EquipmentSlotType type)
    {
        this.name = name;
        slotType = type;
    }

    public EquipableItem getItem()
    {
        return item;
    }

    public void equipItem(final EquipableItem item)
    {
        this.item = item;
    }

    public EquipmentSlotType getSlotType()
    {
        return slotType;
    }

    public String getName()
    {
        return name;
    }
}
